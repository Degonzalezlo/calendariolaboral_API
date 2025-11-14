# Paso 1: FASE DE CONSTRUCCIÓN
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiamos todos los archivos al contenedor
COPY . .

# Ejecutamos Maven para compilar y generar el JAR sin tests, modo batch para logs limpios
RUN mvn clean install -DskipTests -B

# Listado del contenido generado en target para debug
RUN ls -lR target/

# Paso 2: FASE DE EJECUCIÓN (runtime)
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copiamos el JAR generado desde el stage build
COPY --from=build /app/target/*.jar app.jar

# Listamos el contenido del workspace y del JAR para confirmar que está bien copiado
RUN ls -l && \
    file app.jar

EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]

