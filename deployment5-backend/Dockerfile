# a lightweight JDK base image
FROM openjdk:17-jdk-slim

# environment variables (optional)
ENV SERVER_PORT=8080

# thats the working directory created inside the container
WORKDIR /app

# Copy the Maven or Gradle wrapper and configuration files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies only (faster rebuilds)
RUN ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the application using Maven
RUN ./mvnw clean package -DskipTests

# copy your Spring Boot jar file into the container
COPY --from=builder /app/target/*.jar app.jar

# 5. Expose the port your app runs on
EXPOSE 8080

# 6. Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]



