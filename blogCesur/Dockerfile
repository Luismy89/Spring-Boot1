# Stage 1: Build the application
FROM eclipse-temurin:23-jdk AS builder

# Set the working directory
WORKDIR /app

# Copy the application code, including mvnw (Maven Wrapper script)
COPY . .

# Install Maven (if not included in the JDK image)
RUN apt-get update && apt-get install -y maven

# Build the application (using Maven directly)
RUN mvn clean install

# Stage 2: Run the application
FROM eclipse-temurin:23-jre

# Set the working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the app will run on
EXPOSE 9000

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
