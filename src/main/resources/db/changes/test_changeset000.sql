--liquibase formatted sql

--changeset johannes:001
create table test (
    id int primary key,
    name varchar(255)
);