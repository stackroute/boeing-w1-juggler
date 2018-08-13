FROM java:8
VOLUME /tmp
ADD ./target/upstream-service-v1.0.0.jar upstream.jar
EXPOSE 8094
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/test", "-Djava.security.egd=file:/dev/./urandom","-jar","/upstream.jar"]
