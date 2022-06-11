FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD /target/candidate-service-0.0.1.jar candidate-service.jar
ENTRYPOINT ["java", "-jar", "candidate-service.jar"]