# Use an official OpenJDK runtime as the base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file into the container at /app
COPY target/JiraAPIAutomation-1.0.0.jar .

# Run the application
CMD ["java", "-jar", "JiraAPIAutomation-1.0.0.jar"]