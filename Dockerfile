FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8765
ARG JAR_FILE=target/zuul-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]