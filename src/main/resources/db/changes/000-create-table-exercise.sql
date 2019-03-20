--liquibase formatted sql

--changeset johannes:0001-create-table-exercise-ddl
DROP TABLE exercise;
CREATE TABLE exercise (
  id SERIAL,
  chapter_id INTEGER,
  question TEXT,
  answer TEXT,
  test_query TEXT,
  type TEXT -- SELECT, INSERT, CREATE, DROP, DELETE etc
);
