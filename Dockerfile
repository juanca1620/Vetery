FROM eclipse-temurin:21-jre

COPY target/viajesya-api-1.0.0.jar /app/viajesya-api.jar

WORKDIR /app

RUN ./mvnw clean package

RUN java -jar target/viajesya-api-1.0.0.jar

ENTRYPOINT ["java", "-jar", "viajesya-api.jar"]
