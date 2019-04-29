--liquibase formatted sql

--changeset johannes:011-create-tables
CREATE TABLE "album" (
  "id" SERIAL PRIMARY KEY,
  "artist_id" INTEGER,
  "pealkiri" TEXT,
  "ilmumise_kp" DATE
);

CREATE TABLE "artist" (
  "id" SERIAL PRIMARY KEY,
  "nimi" TEXT
);

CREATE TABLE "lugu" (
  "id" SERIAL PRIMARY KEY,
  "album_id" INTEGER,
  "artist_id" INTEGER,
  "pealkiri" TEXT,
  "kestus" INTEGER
);

ALTER TABLE "album" ADD FOREIGN KEY ("artist_id") REFERENCES "artist" ("id");

ALTER TABLE "lugu" ADD FOREIGN KEY ("album_id") REFERENCES "album" ("id");

ALTER TABLE "lugu" ADD FOREIGN KEY ("artist_id") REFERENCES "artist" ("id");
