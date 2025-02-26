
FROM openjdk:8-jre-alpine

EXPOSE 8080

WORKDIR /app

COPY ./target/java-maven-app-1.1.0-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "java-maven-app-1.1.0-SNAPSHOT.jar"]

