--liquibase formatted sql

--changeset johannes:000-create-table-exercise-ddl
CREATE TABLE exercise (
  id SERIAL PRIMARY KEY,
  chapter_id INTEGER,
  question TEXT,
  answer TEXT,
  test_query TEXT,
  type TEXT -- SELECT, INSERT, CREATE, DROP, DELETE etc
);
