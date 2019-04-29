package com.jlaamann.smartsql.exercise.model;

import com.jlaamann.smartsql.exercise.QueryResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ExerciseResult {

    public ExerciseResult(QueryResult queryResult) {
        this.queryResult = queryResult;
    }

    QueryResult queryResult;
    List<String> columns;
    List<List<String>> values;
}
