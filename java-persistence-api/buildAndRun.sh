#!/bin/sh
mvn clean package && docker build -t com.manuelr.javaee/java-persistence-api .
docker rm -f java-persistence-api || true && docker run -d -p 8080:8080 -p 4848:4848 --name java-persistence-api com.manuelr.javaee/java-persistence-api 
