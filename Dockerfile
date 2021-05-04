FROM openjdk:14
EXPOSE 8080
COPY ./bwl-tool-1.0-SNAPSHOT.jar /tool.jar
CMD ["java", "-jar", "/tool.jar"]
