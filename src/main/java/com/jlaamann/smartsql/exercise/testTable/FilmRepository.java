package com.jlaamann.smartsql.exercise.testTable;

import com.jlaamann.smartsql.exercise.testTable.model.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Long> {
    List<Film> findAllByOrderByDirectorAscTitleAsc();
    List<Film> findAllByOrderByVotesDesc();
}
