# Use Eclipse Temurin OpenJDK 21
FROM eclipse-temurin:21-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src

# Install Maven (Alpine version)
RUN apk add --no-cache maven

# Build the project
RUN mvn clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java","-jar","target/demo-0.0.1-SNAPSHOT.jar"]
