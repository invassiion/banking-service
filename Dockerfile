FROM openjdk:17

WORKDIR /app

COPY target/banking-service-0.0.1-SNAPSHOT.jar /app/banking-service-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "banking-service-0.0.1-SNAPSHOT.jar"]