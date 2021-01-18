# MovieRatingProject
This is a movie rating application developed using spring boot (micro-services) + discovery-server (Eureka server/client) + Actuator + devtools + Docker.

## Micro services are registered with eureka discovery server and deployed them in Docker containers.

#### Create application jar & docker images from each dir of micro-services
1. Create an application jar
> gradle clean build

2. Create an images from the location where Dockerfile is available for each spring-boot project 
> docker image build -t ${procet-name} .
> eg. docker image build -t discovery-server

#### Run docker compose command from the location where docker-compose.yml is reasiding
> docker-compose up -d

#
#### Test the microservice using below URL
> http://localhost:8091/catalog/prashant

- If you try to access movie-info-service & ratings-data-service outside of Docker containes it won't be as we haven't exposed them outside of containers for communication.
