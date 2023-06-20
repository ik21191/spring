#FROM openjdk:8
#EXPOSE 8989
#ADD target/spring-batch.jar spring-batch.jar
#ENTRYPOINT [ "java", "-jar", "/spring-batch.jar" ]

FROM maven:3.8-jdk-8
EXPOSE 9090
RUN mkdir /myproject
COPY . /myproject
WORKDIR /myproject
RUN mvn clean package -DskipTests
CMD ["java", "-jar", "target/spring-batch.jar"]