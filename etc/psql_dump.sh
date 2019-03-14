#!/usr/bin/env bash
pg_dump -U postgres > docker-entrypoint-initdb.d/dump.sql --clean