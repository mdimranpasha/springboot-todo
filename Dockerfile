# Use a Maven base image to build the application
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use a slim OpenJDK image to run the application
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/ToDo-0.0.1-SNAPSHOT.jar Todo.jar

EXPOSE 8090
ENTRYPOINT ["java", "-jar", "Todo.jar"]
