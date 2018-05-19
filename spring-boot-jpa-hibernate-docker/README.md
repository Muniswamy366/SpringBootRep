# Spring Boot on Docker connecting to MySQL Docker container

1. Pull MySql image from Docker Hub (https://hub.docker.com/_/mysql/)
`docker pull mysql:5.7`

2. Create MySql container from docker image.
`docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=test -e MYSQL_USER=muni -e MYSQL_PASSWORD=root -d mysql:5.7`

3. In the Spring Boot Application, use the same container name of the mysql instance in the application.properties
`spring.datasource.url = jdbc:mysql://mysql-container:3306/test`

4. Using the Dockerfile create the Docker image.
From the directory of Dockerfile - `docker build . -t spring-boot-jpa-hibernate-docker`

5. Run the Docker image (spring-boot-jpa-hibernate-docker) created in #4.
`docker run -p 8086:8086 --name spring-boot-jpa-hibernate-docker --link mysql-container:mysql -d spring-boot-jpa-hibernate-docker`

# Pulling Image from Docker hub

1. Follow above steps 1 to 3.

2. Pull spring-boot-jpa-hibernate-docker project image from Docker Hub (https://hub.docker.com/r/muniswamy/springbootrep/)
`docker pull muniswamy/springbootrep`

3. Run the Docker image (spring-boot-jpa-hibernate-docker) created in #4.
`docker run -p 8086:8086 --name spring-boot-jpa-hibernate-docker --link mysql-container:mysql -d muniswamy/springbootrep`

# Sample Request

{
"id":1,
"name":"muni",
"salary":200
}

## Useful Docker commands
- `docker images`
- `docker container ls`
- `docker logs <container_name>`
- `docker container rm <container_name`
- `docker image rm <image_name`
