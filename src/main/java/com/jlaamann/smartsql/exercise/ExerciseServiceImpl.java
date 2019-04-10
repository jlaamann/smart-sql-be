package com.jlaamann.smartsql.exercise;

import com.jlaamann.smartsql.docker.DockerService;
import com.jlaamann.smartsql.exercise.model.Exercise;
import com.jlaamann.smartsql.exercise.model.ExerciseResult;
import com.jlaamann.smartsql.exercise.model.ExerciseValidationModel;
import com.jlaamann.smartsql.exercise.testTable.FilmRepository;
import com.jlaamann.smartsql.exercise.testTable.model.Film;
import com.jlaamann.smartsql.util.CommandLineUtil;
import com.jlaamann.smartsql.util.PathUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final DockerService dockerService;
    private final ExerciseRepository exerciseRepository;
    private final FilmRepository filmRepository;

    @Override
    public ExerciseResult validateSql(ExerciseValidationModel params) {
        if (params.getSql().trim().length() == 0) {
            return new ExerciseResult(QueryResult.FAIL);
        }
        Exercise exercise = exerciseRepository.findById(params.getId()).get();
        String containerName = dockerService.getContainer();
        ExerciseResult result;
        if (exercise.getType() == StatementType.SELECT) {
            result =  validateSelect(exercise, params.getSql(), containerName);
            // todo run query again on default db and map to objects to show feedback
        } else if (exercise.getType() == StatementType.ORDER) {
            result = validateSelect(exercise, params.getSql(), containerName);
            if (result.getQueryResult() == QueryResult.FAIL) {
                return result;
            }
            result = validateOrderBy(exercise, params.getSql(), containerName);
        } else {
            result = new ExerciseResult(QueryResult.FAIL);
        }
        dockerService.removeContainer(containerName);
        return result;
    }

    private ExerciseResult validateOrderBy(Exercise exercise, String sql, String containerName) {
        // step 1: check if returned data is correct
        ExerciseResult selectResult = validateSelect(exercise, sql, containerName);
        if (selectResult.getQueryResult() == QueryResult.FAIL) {
            return selectResult;
        }
        // step 2: check ordering
        List<Film> outputObjects = runQuery(sql, containerName);
        List<Film> correctResult = runQuery(exercise.getTestQuery(), containerName);
        // todo: atm requires that order by exercise queries contain id field
        return outputObjects != null && isSameOrder(outputObjects, correctResult) ? new ExerciseResult(QueryResult.OK)
                : new ExerciseResult(QueryResult.FAIL);
    }

    private List<Film> parseOutput(List<String> output) {
        if (output.isEmpty()) {
            return null;
        }
        List<Film> films = new ArrayList<>();
        List<String> columns = Arrays.stream(output.get(0).split("[|]"))
                .map(s -> s = s.trim()).collect(Collectors.toList());
        for (String line : output.subList(2, output.size() - 1)) {
            List<String> columnValues = Arrays.stream(line.split("[|]"))
                    .map(s -> s = s.trim()).collect(Collectors.toList());
            Film film = createFilm(columns, columnValues);
            if (film != null) {
                films.add(createFilm(columns, columnValues));
            }
        }
        return films;
    }

    private Film createFilm(List<String> columns, List<String> columnValues) {
        if (columns.size() != columnValues.size()) {
            return null;
        }
        Film film = new Film();
        for (int i = 0; i < columns.size(); i++) {
            String col = columns.get(i);
            if (col.toLowerCase().equals("id")) {
                film.setId(Long.valueOf(columnValues.get(i)));
            } else if (col.toLowerCase().equals("title")) {
                film.setTitle(columnValues.get(i));
            } else if (col.toLowerCase().equals("director")) {
                film.setDirector(columnValues.get(i));
            } else if (col.toLowerCase().equals("release_date")) {
                film.setReleaseDate(LocalDate.parse(columnValues.get(i)));
            } else if (col.toLowerCase().equals("votes")) {
                film.setVotes(Long.valueOf(columnValues.get(i)));
            } else if (col.toLowerCase().equals("runtime")) {
                film.setRuntime(Long.valueOf(columnValues.get(i)));
            } else if (col.toLowerCase().equals("country")) {
                film.setCountry(columnValues.get(i));
            }
        }
        return film;
    }

    private boolean isSameOrder(List<Film> listA, List<Film> listB) {
        if (listA.size() != listB.size()) {
            return false;
        }
        for (int i = 0; i < listA.size(); i++) {
            if (listA.get(i).getId() != listB.get(i).getId()) {
                return false;
            }
        }
        return true;
    }

    private List<Film> runQuery(String sql, String containerName) {
        List<String> command = Arrays.asList("./docker_exec.sh", containerName, sql);
        List<String> output = new ArrayList<>();
        try {
            CommandLineUtil.runCommand(command, PathUtil.getEvalScriptPath(), line -> {
                System.out.println(line);
                output.add(line);
            });
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return parseOutput(output);
    }

    private ExerciseResult validateSelect(Exercise exercise, String sql, String containerName) {
        List<String> command = Arrays.asList("./docker_eval_select.sh", containerName, sql, exercise.getTestQuery());
        List<String> output = new ArrayList<>();
        try {
            CommandLineUtil.runCommand(command, PathUtil.getEvalScriptPath(), line -> {
                System.out.println(line);
                output.add(line);
            });
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return new ExerciseResult(QueryResult.FAIL);
        }
        return output.contains("(0 rows)") ? new ExerciseResult(QueryResult.OK) : new ExerciseResult(QueryResult.FAIL);
    }
}
