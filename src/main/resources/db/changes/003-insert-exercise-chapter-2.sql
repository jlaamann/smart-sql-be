--liquibase formatted sql

--changeset johannes:0031-insert-exercise-chapter-2
insert into exercise (answer, chapter_id, question, test_query, type) values
('SELECT * FROM film WHERE country = ''United States'' AND director = ''Alfred Hitchcock'';',
 2,
 'Leia kõik kirjed tabelist FILM, mille päritolumaaks (country) on Ameerika Ühendriigid (United States) ja režissööriks (director) Alfred Hitchcock',
 'SELECT * FROM film WHERE country = ''United States'' AND director = ''Alfred Hitchcock'';',
 'SELECT');

insert into exercise (answer, chapter_id, question, test_query, type) values
('SELECT * FROM film WHERE country = ''Italy'' OR country = ''France'';',
 2,
 'Leia kõik kirjed tabelist FILM, mille päritolumaaks (country) on Itaalia (Italy) või Prantsusmaa (France)',
'SELECT * FROM film WHERE country = ''Italy'' OR country = ''France'';',
 'SELECT');

insert into exercise (answer, chapter_id, question, test_query, type) values
( 'SELECT * FROM film WHERE director != ''Andrei Tarkovsky'';',
 2,
 'Leia kõik kirjed tabelist FILM, mille režissööriks (director) ei ole Andrei Tarkovsky',
 'SELECT * FROM film WHERE director != ''Andrei Tarkovsky'';',
 'SELECT');
