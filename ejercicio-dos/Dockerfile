FROM openjdk:11-jdk-alpine

ARG APP_ENV=dev
ARG APP_XMX=256m
ARG APP_XMS=128m
ARG JAR_FILE=target/*.jar

ENV APP_PROFILE=${APP_ENV}

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]