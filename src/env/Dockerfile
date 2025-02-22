FROM openjdk:17
EXPOSE 8081
ARG JAR_FILE=Referral-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} Referral-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=dockerize","-jar","/Referral-0.0.1-SNAPSHOT.jar"]