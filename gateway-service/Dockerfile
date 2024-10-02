FROM openjdk:17-jdk-alpine
COPY target/gateway-service.jar /app/gateway-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/gateway-service.jar"]
