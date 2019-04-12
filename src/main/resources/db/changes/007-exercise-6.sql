--liquibase formatted sql

--changeset johannes:0071-exercise
insert into exercise (answer, chapter_id, question, test_query, type) values
( 'INSERT INTO raamat (pealkiri, autor, pikkus) VALUES (''Sõda ja rahu'', ''Lev Tolstoi'', 1225);',
 6,
 'Meil on olemas tabel RAAMAT väljadega id (INTEGER), pealkiri (TEXT), autor (TEXT) ja pikkus (INTEGER). Sisesta tabelisse kirje, kus raamatu pealkirjaks on “Sõda ja rahu”, autoriks  Lev Tolstoi ning pikkuseks 1225.',
 'CREATE TABLE raamat (id SERIAL, pealkiri TEXT, autor TEXT, pikkus INTEGER);',
 'INSERT');
