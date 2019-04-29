package com.jlaamann.smartsql.exercise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class QueryOutput {
    private List<String> columns = new ArrayList<>();
    private List<List<String>> values = new ArrayList<>();
}
