package com.jlaamann.smartsql.exercise;

import com.jlaamann.smartsql.docker.DockerService;
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
        if (params.getStatementType() == StatementType.SELECT) {
            return new ExerciseResult(QueryResult.OK);
        }
        return new ExerciseResult(QueryResult.FAIL);
    }
}
