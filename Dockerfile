# Стадия сборки
FROM gradle:8.8-jdk17 AS build
WORKDIR /app
COPY settings.gradle.kts .
COPY src ./src
RUN gradle bootJar

# Стадия запуска
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY /build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]