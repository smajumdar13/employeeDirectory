FROM eclipse-temurin:17
ARG JAR_FILE=target/*.jar
COPY ./target/EmployeeDirectory-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]