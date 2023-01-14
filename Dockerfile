FROM openjdk:17-jdk-slim

ADD target/example-0.0.6-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]

EXPOSE 8083