# Use the Maven image to build the project
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

COPY pom.xml .
COPY src ./src


RUN mvn clean package -DskipTests


FROM openjdk:17-jdk-slim


WORKDIR /app


COPY --from=build /app/target/NiwemutoniAnneDivine_Ecommerce_Project-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 8080


ENTRYPOINT ["java", "-jar","app.jar"]