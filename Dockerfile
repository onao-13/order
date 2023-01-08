FROM adoptopenjdk/openjdk14:x86_64-alpine-jre-14.0.2_12

WORKDIR /app
ADD example-0.0.1-SNAPSHOT.jar app.jar
CMD java -jar ./app.jar