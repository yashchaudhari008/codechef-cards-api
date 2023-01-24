FROM maven:3.8.6-openjdk-18-slim AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:18-jdk-alpine3.14
COPY --from=build target/codechef-cards-api-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]