FROM openjdk:8-jdk-alpine

LABEL maintainer="luojianhe1992@gmail.com"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/spring-boot-mybatis-mysql-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} spring-boot-mybatis-mysql-0.0.1-SNAPSHOT.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-boot-mybatis-mysql-0.0.1-SNAPSHOT.jar"]


