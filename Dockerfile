FROM openjdk:14
VOLUME /tmp
EXPOSE 9090
COPY Clips-1.0.0.jar /Clips-1.0.0.jar
ENTRYPOINT ["java","-jar","Clips-1.0.0.jar"]