--liquibase formatted sql

--changeset johannes:013-migra
update exercise set chapter_id = chapter_id + 1
where type IN ('DELETE');
