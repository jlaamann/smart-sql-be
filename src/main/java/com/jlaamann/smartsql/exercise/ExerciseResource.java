package com.jlaamann.smartsql.exercise;

import com.jlaamann.smartsql.exercise.model.Exercise;
import com.jlaamann.smartsql.exercise.model.ExerciseResult;
import com.jlaamann.smartsql.exercise.model.ExerciseValidationModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExerciseResource {

    private final ExerciseService exerciseService;
    private final ExerciseRepository exerciseRepository;

    @GetMapping("/exercise/chapter/{chapterId}")
    List<Exercise> getByChapterId(@PathVariable long chapterId) {
        return exerciseRepository.findAllByChapterId(chapterId);
    }

    @PostMapping("/exercise")
    ExerciseResult validateSql(@RequestBody ExerciseValidationModel params){
        return exerciseService.validateSql(params);
    }
}
