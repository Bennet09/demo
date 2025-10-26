# Use Eclipse Temurin JDK 21
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml first (for caching dependencies)
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Download dependencies offline
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Package the application
RUN ./mvnw clean package -DskipTests

# Expose the port your app runs on
EXPOSE 8080

# Run the Spring Boot jar
ENTRYPOINT ["java","-jar","target/demo-0.0.1-SNAPSHOT.jar"]
