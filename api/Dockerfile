#define base docker image
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
EXPOSE 9000
LABEL maintainer="medhead.com"
ADD target/*.jar api.jar
ENTRYPOINT ["java","-jar","api.jar"]