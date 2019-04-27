#!/usr/bin/env bash

# Initializing postgres db with dump data takes about 1.5 seconds
# todo: find a better way?

sleep 2.5;

#RETRIES=20
#until [ $RETRIES -eq 0 ]; do
#  echo "Waiting for postgres server, $((RETRIES--)) remaining attempts..."
#  sleep 0.2
#done
