#!/usr/bin/env bash

file="/docker-entrypoint-initdb.d/dump.sql"

echo "Restoring DB using $file"
psql -U postgres -d postgres  -f  "$file"