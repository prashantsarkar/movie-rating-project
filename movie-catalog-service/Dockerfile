From openjdk:8
copy ./build/libs/movie-catalog-service-0.0.1-SNAPSHOT.jar movie-catalog-service-0.0.1-SNAPSHOT.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar movie-catalog-service-0.0.1-SNAPSHOT.jar" ]