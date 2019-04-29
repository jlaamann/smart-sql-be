--liquibase formatted sql

--changeset johannes:012-migra
update exercise set chapter_id = chapter_id + 1
where type IN ('INSERT', 'CREATE_TABLE');
