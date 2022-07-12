FROM maven:3.8.2-jdk-11
WORKDIR /auth-service
COPY . .

RUN mvn clean install
CMD mvn spring-boot:run