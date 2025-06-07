
# Use a lightweight JDK base image
FROM openjdk:17-jdk-slim

# Optional environment variable
ENV SERVER_PORT=8080

# Set working directory
WORKDIR /app

# Copy springboot jar file into container
COPY target/deployment5-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the built jar
ENTRYPOINT ["java", "-jar", "app.jar"]

