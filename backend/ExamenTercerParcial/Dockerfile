FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/ExamenTercerParcial-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8097

ENTRYPOINT ["java","-jar","app.jar"]