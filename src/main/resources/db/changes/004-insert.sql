--liquibase formatted sql

--changeset johannes:0040-insert
insert into exercise (answer, chapter_id, question, test_query, type) values
('SELECT * FROM film WHERE director LIKE ''J%'';',
 3,
 'Leia kõikide režissööride nimed (director) tabelist FILM, kelle eesnimi (director) algab tähega J',
 'SELECT director FROM film WHERE director LIKE ''J%'';',
 'SELECT');

insert into exercise (answer, chapter_id, question, test_query, type) values
('SELECT * FROM film WHERE country IN (''Japan'', ''Denmark'', ''Sweden'');',
 3,
 'Leia kõik kirjed tabelist FILM, mille päritolumaa (country) on Jaapan (Japan), Taani (Denmark) või Rootsi (Sweden)',
'SELECT * FROM film WHERE country IN (''Japan'', ''Denmark'', ''Sweden'');',
 'SELECT');
