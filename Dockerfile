FROM openjdk:17
COPY build/risk-profile-api.jar risk-profile-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/risk-profile-api.jar"]