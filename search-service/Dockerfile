
FROM java:8
VOLUME /tmp
ADD ./target/search-service-v1.0.0.jar search.jar
EXPOSE 8093
RUN bash -c 'touch /search.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongocontainer2/search", "-Djava.security.egd=file:/dev/./urandom","-jar","/search.jar"]
