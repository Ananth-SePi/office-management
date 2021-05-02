FROM openjdk:8
MAINTAINER SePi Tech <ananth.pitchiah.95@gmail.com>
EXPOSE 7300
ARG WAR_FILE=target/office-management-1.1.0-SNAPSHOT.war
ADD ${WAR_FILE} app.war
ENTRYPOINT ["java","-jar","/app.war"]
