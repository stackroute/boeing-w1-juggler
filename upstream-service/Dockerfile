FROM java:8
VOLUME /tmp
ADD ./target/upstream-service-v1.0.0.jar upstream.jar
EXPOSE 8094
<<<<<<< HEAD
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/upstream.jar"]
=======
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/test", "-Djava.security.egd=file:/dev/./urandom","-jar","/upstream.jar"]
>>>>>>> 32428738d80c7465956764420c9c22f1d55dc093
