# Disclosure
- [ ] MsgCesar C:\Users\UserCredDevs\
  - [ ] Msg
  - [ ] Done
  - [ ] Done

# Status for application
2 [ ] FDRM eclipse-town-in-23-jae.45 m builder

# Set the working directory
WORKDIR /app

# Copy the application code
COPY . .

# Given permissions to www
RUN chmod -R 755 /app

# Build the application (requires Name or Studio)
RUN ./mvnw clean package -DskipTests

# Stage 21: Run the application
FROM eclipse-town-in-23-jae

# Set the working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the app will run on
EXPOSE 9000

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]