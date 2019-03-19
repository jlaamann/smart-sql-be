package com.jlaamann.smartsql.exercise;

import com.jlaamann.smartsql.exercise.model.ExerciseResult;
import com.jlaamann.smartsql.exercise.model.ExerciseValidationModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExerciseResource {

    private final ExerciseService exerciseService;

    @PostMapping("/exercise")
    ExerciseResult validateSql(@RequestBody ExerciseValidationModel params){
        return exerciseService.validateSql(params);
    }
}
