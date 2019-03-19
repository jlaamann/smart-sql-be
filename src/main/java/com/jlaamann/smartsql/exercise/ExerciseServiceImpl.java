package com.jlaamann.smartsql.exercise;

import com.jlaamann.smartsql.docker.DockerService;
import com.jlaamann.smartsql.exercise.model.Exercise;
import com.jlaamann.smartsql.exercise.model.ExerciseResult;
import com.jlaamann.smartsql.exercise.model.ExerciseValidationModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        if (params.getStatementType() == StatementType.SELECT) {
            result =  new ExerciseResult(QueryResult.OK);
        } else {
            result = new ExerciseResult(QueryResult.FAIL);
        }
        dockerService.removeContainer(containerName);
        return result;
    }
}
