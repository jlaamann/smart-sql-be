--liquibase formatted sql

--changeset johannes:0052-insert
insert into exercise (answer, chapter_id, question, test_query, type) values
('SELECT * FROM film ORDER BY votes DESC;',
 4,
 'Leia kõik filmid häälte (votes) arvu järgi kahanevas järjestuses',
 'SELECT * FROM film ORDER BY votes DESC;',
 'ORDER');

insert into exercise (answer, chapter_id, question, test_query, type) values
('SELECT * FROM film ORDER BY country, runtime ASC;',
 4,
 'Leia kõik filmid esmalt riigi (country) ning siis pikkuse (runtime) järgi kasvavas järjekorras',
'SELECT * FROM film ORDER BY country, runtime ASC;',
 'ORDER');
