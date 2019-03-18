#!/bin/bash
docker exec -i $1 bin/bash<<EOF
psql -U postgres -d postgres -c "select * from film"
EOF
