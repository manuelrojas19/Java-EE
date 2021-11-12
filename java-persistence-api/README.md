# Build
mvn clean package && docker build -t com.manuelr.javaee/java-persistence-api .

# RUN

docker rm -f java-persistence-api || true && docker run --add-host=host.docker.internal:172.17.0.1  -d -p 8080:8080 -p 4848:4848 --name java-persistence-api com.manuelr.javaee/java-persistence-api 