package com.jlaamann.smartsql.exercise.model;

import com.jlaamann.smartsql.exercise.StatementType;
import lombok.Data;

@Data
public class ExerciseValidationModel {
    public long id;
    public String sql;
    public StatementType statementType;
}
