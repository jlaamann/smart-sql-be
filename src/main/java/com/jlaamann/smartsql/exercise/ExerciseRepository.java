package com.jlaamann.smartsql.exercise;

import com.jlaamann.smartsql.exercise.model.Exercise;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
    List<Exercise> findAllByChapterId(Long chapterId);
}
