
FROM maven:3.8.6-openjdk-17 AS build

# Copiamos el código fuente al contenedor
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Compilamos el proyecto y generamos el JAR (skip tests para más rapidez)
RUN mvn clean package -DskipTests

# Segunda etapa: imagen más liviana para ejecutar la app
FROM openjdk:17-jdk-slim

# Copiamos el JAR generado de la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Puerto en el que la app escuchará (usa variable PORT en runtime)
ENV PORT=8080
EXPOSE $PORT

# Ejecutamos la app
ENTRYPOINT ["java", "-jar", "/app.jar"]
