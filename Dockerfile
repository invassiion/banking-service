FROM openjdk:17

WORKDIR /app

COPY target/banking-app.jar /app/banking-app.jar

CMD ["java", "-jar", "banking-app.jar"]