
FROM java:8
VOLUME /tmp
ADD ./target/ticket-service-v1.0.0.jar ticket.jar
EXPOSE 8091
RUN bash -c 'touch /ticket.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongocontainer2/ticket", "-Djava.security.egd=file:/dev/./urandom","-jar","/ticket.jar"]