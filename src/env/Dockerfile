FROM openjdk:17
EXPOSE 8081
ARG JAR_FILE=PostgreSQL.MyBatis-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} PostgreSQL.MyBatis-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/PostgreSQL.MyBatis-0.0.1-SNAPSHOT.jar"]