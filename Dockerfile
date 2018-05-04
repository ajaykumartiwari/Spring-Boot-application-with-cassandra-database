FROM openjdk
VOLUME /tmp
ADD target/Game-Event-0.0.1-SNAPSHOT.jar /Desktop/Project/projectDocker/gevent.jar
WORKDIR /Desktop/Project/projectDocker/
RUN sh -c 'touch gevent.jar'
ENTRYPOINT ["java","-Dspring.data.cassandra.contact-points=cassandra-container-app:9044/gameEvent", "-jar", "gevent.jar"]
