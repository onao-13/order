FROM adoptopenjdk/openjdk14:x86_64-alpine-jre-14.0.2_12

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src/ ./src/

CMD ["./mvnw", "spring-boot:run"]