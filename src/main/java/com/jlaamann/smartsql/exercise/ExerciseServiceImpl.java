package com.jlaamann.smartsql.exercise;

import com.jlaamann.smartsql.docker.DockerService;
import com.jlaamann.smartsql.exercise.model.Exercise;
import com.jlaamann.smartsql.exercise.model.ExerciseResult;
import com.jlaamann.smartsql.exercise.model.ExerciseValidationModel;
import com.jlaamann.smartsql.util.CommandLineUtil;
import com.jlaamann.smartsql.util.PathUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final DockerService dockerService;
    private final ExerciseRepository exerciseRepository;

    @Override
    public ExerciseResult validateSql(ExerciseValidationModel params) {
        Exercise exercise = exerciseRepository.findById(params.getId()).get();
        String containerName = dockerService.getContainer();
        ExerciseResult result;
        if (exercise.getType() == StatementType.SELECT) {
            result =  validateSelect(exercise, params.getSql(), containerName);
            // todo run query again on default db and map to objects to show feedback
        } else {
            result = new ExerciseResult(QueryResult.FAIL);
        }
        dockerService.removeContainer(containerName);
        return result;
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
