FROM gradle:5.6.0-jdk11 as builder
COPY --chown=gradle:gradle . /home/gradle/webapp
WORKDIR /home/gradle/webapp
RUN gradle clean bootJar

FROM adoptopenjdk:11-jre-hotspot
COPY --from=builder /home/gradle/webapp/build/libs/*.jar application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]