#!/bin/bash
psql -U postgres postgres -c "CREATE TABLE lend (id SERIAL NOT NULL, algpunkt TEXT)"
psql -U postgres postgres -c "INSERT INTO lend (algpunkt) VALUES ('Tartu')"