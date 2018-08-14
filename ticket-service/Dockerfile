
FROM java:8
VOLUME /tmp
ADD ./target/ticket-service-1.0.0-SNAPSHOT.jar app.jar
EXPOSE 8091
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongocontainer2/test", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]