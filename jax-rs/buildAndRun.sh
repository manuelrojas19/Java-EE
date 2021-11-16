#!/bin/sh
mvn clean package && docker build -t com.manuelr.javaee/jax-rs .
docker rm -f jax-rs || true && docker run -d -p 8080:8080 -p 4848:4848 --name jax-rs com.manuelr.javaee/jax-rs 
