FROM openjdk:21-jdk-slim as builder
COPY gradlew .

COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootjar

FROM openjdk:21-jdk-slim
COPY --from=builder build/libs/*.jar app.jar
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
