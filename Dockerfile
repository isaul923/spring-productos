FROM openjdk:20-ea-19-jdk
#FROM maven:latest

WORKDIR /app

COPY ./target/springboot-servicio-productos-0.0.1-SNAPSHOT.jar .


RUN sed -i -e 's/\r$//' mvnw
RUN ./mvnw clean package -DskipTests

EXPOSE 8001

ENTRYPOINT ["java" , "-jar" ,"springboot-servicio-productos-0.0.1-SNAPSHOT.jar"]