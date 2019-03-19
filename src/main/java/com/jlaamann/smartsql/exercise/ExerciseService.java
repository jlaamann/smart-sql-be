package com.jlaamann.smartsql.exercise;

import com.jlaamann.smartsql.exercise.model.ExerciseResult;
import com.jlaamann.smartsql.exercise.model.ExerciseValidationModel;

public interface ExerciseService {
    ExerciseResult validateSql(ExerciseValidationModel params);
}
