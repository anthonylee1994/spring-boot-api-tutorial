FROM gradle:8.10.2-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle build -x test

FROM eclipse-temurin:21
VOLUME /tmp
EXPOSE 8082
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "/app.jar"]
