package com.jlaamann.smartsql.exercise.model;

import com.jlaamann.smartsql.exercise.QueryResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ExerciseResult {
    QueryResult queryResult;
}
