FROM openjdk:8-jdk-alpine

ARG JAR_FILE=bitcoinpriceticker-application/build/libs/*.jar
COPY /${JAR_FILE} /app/app.jar

# i can specify which ports should be internally available, however this does not expose them to the host, still need to use -p 8080:8080, so here it is not necessary field
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]