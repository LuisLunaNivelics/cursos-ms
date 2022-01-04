FROM openjdk:11-jre-slim
ADD build/libs/cursos-ms-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8083
ENTRYPOINT [ "java", "-jar", "app.jar"]