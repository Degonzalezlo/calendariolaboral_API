# ======== FASE 1: BUILD =========
FROM public.ecr.aws/docker/library/maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests -B
RUN ls -lR target/

# ======== FASE 2: RUNTIME =========
FROM public.ecr.aws/docker/library/eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]




