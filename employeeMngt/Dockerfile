# Use an official OpenJDK base image (choose the appropriate version)
FROM openjdk:17-jdk-alpine
#name of the owner
MAINTAINER Satya theegela
# Install Maven
#RUN apt-get update && apt-get install -y maven
#Set working directory
WORKDIR /app
COPY . /app
#run the maven build command
#RUN mvn clean install
# Copy the generated JAR file into the container
COPY target/employeeManagement-0.*.jar /app/app.jar
EXPOSE 8080
# Specify the entry point command to run the JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
