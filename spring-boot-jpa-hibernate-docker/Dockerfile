FROM openjdk:8
RUN apt-get update && apt-get install maven
RUN mvn assembly:assembly
ADD target/users-mysql.jar users-mysql.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "users-mysql.jar"]
