FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY target/AuthorizationService-0.0.1-SNAPSHOT.jar app.jar

CMD ["java","-jar","app.jar"]