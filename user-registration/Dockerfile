FROM java:8
VOLUME /tmp
ADD ./target/user-registration-v1.0.0.jar user-registration.jar
EXPOSE 8091
ENTRYPOINT ["java","-Dspring.data.mongodb.uri: mongodb://0.0.0.0:27000/eplay", "-Djava.security.egd=file:/dev/./urandom","-jar","/user-registration.jar"]
