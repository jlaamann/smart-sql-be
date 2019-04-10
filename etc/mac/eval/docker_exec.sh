#!/bin/bash

INPUT_SQL=$2
docker exec -i $1 bin/bash<<EOF
psql -U postgres -d postgres -c "$2";
EOF
