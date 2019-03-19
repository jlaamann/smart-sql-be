package com.jlaamann.smartsql.exercise;

import com.jlaamann.smartsql.exercise.model.Exercise;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

}
