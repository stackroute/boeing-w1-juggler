FROM java:8
VOLUME /tmp
ADD ./target/downstream-service-v1.0.0.jar downstream.jar
EXPOSE 8095
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongocontainer/test", "-Djava.security.egd=file:/dev/./urandom","-jar","/downstream.jar"]
