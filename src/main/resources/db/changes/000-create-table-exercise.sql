--liquibase formatted sql

--changeset johannes:000-create-table-exercise
CREATE TABLE exercise (
  id SERIAL PRIMARY KEY,
  chapter_id INTEGER,
  question TEXT,
  correct_query TEXT
);
