# syntax=docker/dockerfile:1

FROM openjdk:17-jdk-alpine

WORKDIR /app
# copy the packaged jar file into our docker image
COPY ./target/kanban.jar ./kanban.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "/app/kanban.jar"]
