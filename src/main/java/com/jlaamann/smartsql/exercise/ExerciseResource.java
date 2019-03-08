package com.jlaamann.smartsql.exercise;

import com.jlaamann.smartsql.docker.DockerService;
import com.jlaamann.smartsql.exercise.model.Exercise;
import com.jlaamann.smartsql.exercise.model.ExerciseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExerciseResource {

    private final DockerService dockerService;

    @GetMapping("/exercise/test")
    ExerciseResult test() {
        dockerService.getContainer();
        return new ExerciseResult(QueryResult.OK);
    }

}
