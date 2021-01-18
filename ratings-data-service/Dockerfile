From openjdk:8
copy ./build/libs/ratings-data-service-0.0.1-SNAPSHOT.jar ratings-data-service-0.0.1-SNAPSHOT.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar ratings-data-service-0.0.1-SNAPSHOT.jar" ]