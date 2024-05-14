FROM openjdk:11-slim
RUN apt-get update && apt-get -y install netcat && apt-get clean
WORKDIR /appwebflux
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]