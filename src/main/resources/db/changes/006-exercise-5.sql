--liquibase formatted sql

--changeset johannes:006-exercise
insert into exercise (answer, chapter_id, question, test_query, type) values
('CREATE TABLE raamat (id SERIAL, pealkiri TEXT, autor TEXT, pikkus INTEGER);',
 5,
 'Loo tabel RAAMAT, mis koosneks järgnevatest väljadest: id (täisarv), pealkiri (sõne), autor (sõne), pikkus (täisarv)',
 'INSERT INTO raamat (id, pealkiri, autor, pikkus) VALUES (1000, ''pealkiri'', ''autor'', 100);',
 'CREATE_TABLE');
