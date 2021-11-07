#!/bin/sh
mvn clean package && docker build -t com.manuelr.javaee/context-dependency-injection .
docker rm -f context-dependency-injection || true && docker run -d -p 8080:8080 -p 4848:4848 --name context-dependency-injection com.manuelr.javaee/context-dependency-injection 
