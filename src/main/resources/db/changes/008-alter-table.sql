--liquibase formatted sql

--changeset johannes:008-alter-table
ALTER TABLE exercise
ADD COLUMN create_table_sql TEXT;
