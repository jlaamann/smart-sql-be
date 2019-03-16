#!/usr/bin/env bash
pg_dump -U postgres -t tabeli_nimi > docker-entrypoint-initdb.d/dump.sql --clean