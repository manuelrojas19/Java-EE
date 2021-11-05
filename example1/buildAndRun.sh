#!/bin/sh
mvn clean package && docker build -t com.manuelr.javaee/example1 .
docker rm -f example1 || true && docker run -d -p 8080:8080 -p 4848:4848 --name example1 com.manuelr.javaee/example1 
