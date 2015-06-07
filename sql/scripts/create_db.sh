#!/bin/bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
PORT="12801"
psql -p $PORT $DB_NAME < $DIR/../src/create_tables.sql
psql -p $PORT $DB_NAME < $DIR/../src/create_indexes.sql
psql -p $PORT $DB_NAME < $DIR/../src/load_data.sql
