
FROM java:8
VOLUME /tmp
ADD ./target/user-registration-v1.0.0.jar user.jar
EXPOSE 8090
RUN bash -c 'touch /user.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://127.0.0.1:27000/eplay", "-Djava.security.egd=file:/dev/./urandom","-jar","/user.jar"]