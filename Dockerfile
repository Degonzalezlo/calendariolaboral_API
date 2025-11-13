# Paso 1: FASE DE CONSTRUCCIÓN
# Usamos una imagen de Maven que soporta JDK 21 para el proceso de compilación
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copia el código fuente
COPY . .

# Compila el proyecto y genera el JAR final
RUN mvn clean install -DskipTests

# Paso 2: FASE DE EJECUCIÓN (Runtime)
# Usamos una imagen OpenJDK más ligera (Slim) que solo contiene el JRE 21 necesario para ejecutar la aplicación
FROM openjdk:21-jdk-slim
WORKDIR /app

# CORRECCIÓN: Copiamos el JAR con el nombre y la ruta correctos desde el módulo principal.
# El JAR generado es 'diasfestivos-0.0.1-SNAPSHOT.jar'
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
# Ejecuta el JAR
CMD ["java", "-jar", "app.jar"]
