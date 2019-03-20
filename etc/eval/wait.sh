#!/usr/bin/env bash

# Initializing postgres db with dump data takes about 1.5 seconds
RETRIES=2
until [ $RETRIES -eq 0 ]; do
  echo "Waiting for postgres server, $((RETRIES--)) remaining attempts..."
  sleep 0.8
done
