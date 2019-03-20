package com.jlaamann.smartsql.exercise.model;

import com.jlaamann.smartsql.exercise.StatementType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long chapterId;
    private String question;
    private String answer;
    private String testQuery;
    @Enumerated(EnumType.STRING)
    private StatementType type;
}
