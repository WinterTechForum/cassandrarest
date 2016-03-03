FROM jeanblanchard/busybox-java

RUN mkdir /app
COPY target/uberjar/cassandrarest-0.1.0-SNAPSHOT-standalone.jar /app/

ENTRYPOINT ["/opt/jdk/bin/java", "-jar", "/app/cassandrarest-0.1.0-SNAPSHOT-standalone.jar"]

