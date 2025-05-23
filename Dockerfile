FROM eclipse-temurin:21-jre

COPY target/viajesya-api-1.0.0.jar /app/viajesya-api.jar

WORKDIR /app

RUN ./mvnw clean package

ENTRYPOINT ["java", "-jar", "viajesya-api.jar"]
