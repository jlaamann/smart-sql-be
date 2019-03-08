package com.jlaamann.smartsql.exercise;

import com.jlaamann.smartsql.docker.DockerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExerciseResource {

    private final DockerService dockerService;

    @GetMapping("/exercise/test")
    void test() {
        dockerService.getContainer();
    }

}
