package com.jlaamann.smartsql.exercise;

import com.jlaamann.smartsql.docker.DockerService;
import com.jlaamann.smartsql.exercise.model.Exercise;
import com.jlaamann.smartsql.exercise.model.ExerciseResult;
import com.jlaamann.smartsql.exercise.model.ExerciseValidationModel;
import com.jlaamann.smartsql.exercise.testTable.model.Film;
import com.jlaamann.smartsql.util.CommandLineUtil;
import com.jlaamann.smartsql.util.CommandUtil;
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
        } else if (exercise.getType() == StatementType.ORDER) {
            result = validateOrderBy(exercise, params.getSql(), containerName);
        } else if (exercise.getType() == StatementType.CREATE_TABLE) {
            result = validateCreateTable(exercise, params.getSql(), containerName);
        } else if (exercise.getType() == StatementType.INSERT) {
            result = validateInsert(exercise, params.getSql(), containerName);
        } else if (exercise.getType() == StatementType.UPDATE) {
            result = validateUpdate(exercise, params.getSql(), containerName);
        } else if (exercise.getType() == StatementType.DELETE) {
            result = validateDelete(exercise, params.getSql(), containerName);
        } else {
            result = new ExerciseResult(QueryResult.FAIL);
        }
        dockerService.removeContainer(containerName);
        return result;
    }

    private ExerciseResult validateDelete(Exercise exercise, String sql, String containerName) {
        List<String> delete = Arrays.asList(CommandUtil.getDockerExecCmd(), containerName, sql);
        List<String> eval = Arrays.asList(CommandUtil.getDockerExecCmd(), containerName, exercise.getTestQuery());
        List<String> output = new ArrayList<>();
        try {
            CommandLineUtil.runCommand(Arrays.asList("./wait.sh"), PathUtil.getEvalScriptPath());
            CommandLineUtil.runCommand(delete, PathUtil.getEvalScriptPath());
            CommandLineUtil.runCommand(eval, PathUtil.getEvalScriptPath(), line -> {
                System.out.println(line);
                output.add(line);
            });
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return new ExerciseResult(QueryResult.FAIL);
        }
        return output.stream().anyMatch(line -> line.contains("(0 rows)")) ? new ExerciseResult(QueryResult.OK)
                : new ExerciseResult(QueryResult.FAIL);
    }

    private ExerciseResult validateUpdate(Exercise exercise, String sql, String containerName) {
        List<String> update = Arrays.asList(CommandUtil.getDockerExecCmd(), containerName, sql);
        List<String> eval = Arrays.asList(CommandUtil.getDockerExecCmd(), containerName, exercise.getTestQuery());
        List<String> output = new ArrayList<>();
        try {
            CommandLineUtil.runCommand(Arrays.asList("./wait.sh"), PathUtil.getEvalScriptPath());
            CommandLineUtil.runCommand(update, PathUtil.getEvalScriptPath());
            CommandLineUtil.runCommand(eval, PathUtil.getEvalScriptPath(), line -> {
                System.out.println(line);
                output.add(line);
            });
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return new ExerciseResult(QueryResult.FAIL);
        }
        return output.stream().anyMatch(line -> line.contains("(1 row)")) ? new ExerciseResult(QueryResult.OK)
                : new ExerciseResult(QueryResult.FAIL);
    }

    private ExerciseResult validateInsert(Exercise exercise, String sql, String containerName) {
        List<String> commandCreateTable = Arrays.asList(CommandUtil.getDockerExecCmd(), containerName, exercise.getCreateTableSql());
        List<String> commandInsert = Arrays.asList(CommandUtil.getDockerExecCmd(), containerName, sql);
        List<String> eval = Arrays.asList(CommandUtil.getDockerExecCmd(), containerName, exercise.getTestQuery());
        List<String> output = new ArrayList<>();
        try {
            CommandLineUtil.runCommand(Arrays.asList("./wait.sh"), PathUtil.getEvalScriptPath());
            CommandLineUtil.runCommand(commandCreateTable, PathUtil.getEvalScriptPath());
            CommandLineUtil.runCommand(commandInsert, PathUtil.getEvalScriptPath());
            CommandLineUtil.runCommand(eval, PathUtil.getEvalScriptPath(), line -> {
                System.out.println(line);
                output.add(line);
            });
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return new ExerciseResult(QueryResult.FAIL);
        }
        return output.stream().anyMatch(line -> line.contains("(1 row)")) ? new ExerciseResult(QueryResult.OK)
                : new ExerciseResult(QueryResult.FAIL);
    }

    private ExerciseResult validateOrderBy(Exercise exercise, String sql, String containerName) {
        // step 1: check if returned data is correct
        ExerciseResult selectResult = validateSelect(exercise, sql, containerName);
        if (selectResult.getQueryResult() == QueryResult.FAIL) {
            return selectResult;
        }
        // step 2: check ordering
        List<Film> outputObjects = mapQueryToFilm(sql, containerName);
        List<Film> correctResult = mapQueryToFilm(exercise.getTestQuery(), containerName);
        return outputObjects != null && isSameOrder(outputObjects, correctResult) ? new ExerciseResult(QueryResult.OK)
                : new ExerciseResult(QueryResult.FAIL);
    }

    private ExerciseResult validateCreateTable(Exercise exercise, String sql, String containerName) {
        List<String> commandCreate = Arrays.asList(CommandUtil.getDockerExecCmd(), containerName, sql);
        List<String> commandTest = Arrays.asList(CommandUtil.getDockerExecCmd(), containerName, exercise.getTestQuery());
        List<String> output = new ArrayList<>();
        try {
            CommandLineUtil.runCommand(Arrays.asList("./wait.sh"), PathUtil.getEvalScriptPath());
            CommandLineUtil.runCommand(commandCreate, PathUtil.getEvalScriptPath());
            CommandLineUtil.runCommand(commandTest, PathUtil.getEvalScriptPath(), line -> {
                System.out.println(line);
                output.add(line);
            });
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return new ExerciseResult(QueryResult.FAIL);
        }
        // TODO: check column count as well
        return output.stream().noneMatch(line -> line.toLowerCase().contains("error")) ?
                new ExerciseResult(QueryResult.OK) : new ExerciseResult(QueryResult.FAIL);
    }

    private List<Film> parseOutputToFilm(List<String> output) {
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
            if (!listA.get(i).equals(listB.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<Film> mapQueryToFilm(String sql, String containerName) {
        List<String> command = Arrays.asList(CommandUtil.getDockerExecCmd(), containerName, sql);
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
        return parseOutputToFilm(output);
    }

    private ExerciseResult validateSelect(Exercise exercise, String sql, String containerName) {
        List<String> command = Arrays.asList(CommandUtil.getDockerEvalSelectCmd(), containerName, sql, exercise.getTestQuery());
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
