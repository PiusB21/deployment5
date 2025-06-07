# Use a lightweight JDK base image
FROM openjdk:17-jdk-slim

# Optional environment variable
ENV SERVER_PORT=8080

# Set working directory
WORKDIR /app

# Copy everything at once (or separately if preferred)
COPY . .

# Grant execute permissions to the Maven wrapper
RUN chmod +x mvnw

# Build the app using the Maven wrapper
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the built jar
ENTRYPOINT ["java", "-jar", "target/app.jar"]

