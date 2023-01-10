FROM adoptopenjdk/openjdk14:x86_64-alpine-jre-14.0.2_12

ADD target/example-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]

EXPOSE 8083