#!/bin/bash
sudo docker run -d -p $2:5432 --name $1 -e POSTGRES_PASSWORD=password pg-docker