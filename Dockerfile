FROM 3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /target/ToDo-0.0.1-SNAPSHOT.jar Todo.jar

EXPOSE 8090
ENTRYPOINT ["java","-jar","ToDo.jar"]
