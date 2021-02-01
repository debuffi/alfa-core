FROM openjdk:8u265-jre-slim

ARG JAR_FILE=target/alfa-core.jar
COPY ${JAR_FILE} alfa-core.jar

EXPOSE 8080

ENTRYPOINT ["java", "-DTYPE_PATH=classpath:/storage.xml", "-jar", "/alfa-core.jar"]