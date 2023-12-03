FROM maven:3.9.5-eclipse-temurin-17 AS lbcproject
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/app/target/lbc_fizzbuzz-0.0.1-SNAPSHOT.jar"]