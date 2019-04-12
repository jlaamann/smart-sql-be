--liquibase formatted sql

--changeset johannes:009-update
UPDATE exercise
SET create_table_sql = 'CREATE TABLE raamat (id SERIAL, pealkiri TEXT, autor TEXT, pikkus INTEGER);',
  test_query = 'SELECT * FROM raamat WHERE pealkiri = ''Sõda ja rahu'' AND autor = ''Lev Tolstoi'' AND pikkus = 1225'
  WHERE chapter_id = 6;
