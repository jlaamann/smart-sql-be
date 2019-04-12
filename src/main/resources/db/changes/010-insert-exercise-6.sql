--liquibase formatted sql

--changeset johannes:010-insert-exercise-6
insert into exercise (answer, chapter_id, question, test_query, type) values
( 'DELETE FROM film WHERE votes < 50;',
 6,
 'Kustuta tabelist FILM kõik kirjed, millel on hääli (votes) vähem kui 50',
 'SELECT * FROM film WHERE votes < 50;',
 'DELETE');
