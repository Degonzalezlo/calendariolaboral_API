# ======== FASE 1: BUILD ========
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar todo el código al contenedor
COPY . .

# Compilar el proyecto Maven
RUN mvn clean package -DskipTests

# ======== FASE 2: RUNTIME ========
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copiar cualquier JAR generado desde target/
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Comando de arranque del microservicio
CMD ["java", "-jar", "app.jar"]



