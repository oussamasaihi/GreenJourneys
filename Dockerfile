FROM openjdk:17
EXPOSE 9090
COPY target/GreenJourneys-0.0.1-SNAPSHOT.jar GreenJourneys-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar", "/GreenJourneys-0.0.1-SNAPSHOT.jar"]