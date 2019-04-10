#!/bin/bash

./wait.sh;

INPUT_SQL=$2
CORRECT_SQL=$3
CREATE_A="CREATE OR REPLACE VIEW v_input AS $INPUT_SQL"
CREATE_B="CREATE OR REPLACE VIEW v_correct AS $CORRECT_SQL"
echo "$CREATE_A";
echo "$CREATE_B";
docker exec -i $1 bin/bash<<EOF
psql -U postgres -d postgres -c "$CREATE_A";
psql -U postgres -d postgres -c "$CREATE_B";
psql -U postgres -d postgres -c "(select * from v_input except all select * from v_correct) union all (select * from v_correct except all select * from v_input)";
EOF
