--liquibase formatted sql

--changeset johannes:0026-insert-exercise-chapter-1
insert into exercise (answer, chapter_id, question, test_query, type) values
('SELECT * FROM film WHERE country = ''Italy'';',
 1,
 'Leia tabelist FILM kirjed, mille riigiks (country) on Itaalia (Italy)',
 'SELECT * FROM film WHERE country = ''Italy'';',
 'SELECT');

insert into exercise (answer, chapter_id, question, test_query, type) values
('SELECT * FROM film WHERE title = ''L''''Atalante'';',
 1,
 'Leia tabelist FILM kirjed, mille pealkiri (title) on "L''Atalante"',
 'SELECT * FROM film WHERE title = ''L''''Atalante'';',
 'SELECT');

insert into exercise (answer, chapter_id, question, test_query, type) values
( 'SELECT * FROM film WHERE runtime < 60;',
 1,
 'Leia tabelist FILM kõik kirjed, mille pikkus (runtime) on väiksem kui 60 minutit',
 'SELECT * FROM film WHERE runtime < 60;',
 'SELECT');
