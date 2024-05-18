# Use an official OpenJDK base image (choose the appropriate version)
FROM openjdk:17-jdk-alpine
#name of the owner
MAINTAINER Satya theegela
# Copy the generated JAR file into the container
COPY target/sampleapp-0.*.jar app.jar
EXPOSE 8080
# Specify the entry point command to run the JAR
ENTRYPOINT ["java", "-jar", "/app.jar"]
