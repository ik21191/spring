FROM openjdk:8
EXPOSE 8080
ADD target/spring-rest.jar spring-rest.jar
ENTRYPOINT [ "java", "-jar", "/spring-rest.jar" ]

#FROM maven:3.8-jdk-8
#EXPOSE 9090
#RUN mkdir /myproject
#COPY . /myproject
#WORKDIR /myproject
#RUN mvn clean package -DskipTests
#CMD ["java", "-jar", "target/spring-rest.jar"]