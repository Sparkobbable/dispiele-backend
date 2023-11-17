FROM maven:3.8.4-openjdk-17 AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn -Dmaven.test.skip=true package

FROM openjdk:17-jdk
ARG JAVA_OPTS
ARG STAGE
COPY --from=MAVEN_BUILD ./build/target/*.jar /app/dispiele-backend.jar
ENV JAVA_OPTS=$JAVA_OPTS
ARG STAGE=$STAGE
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -Dspring.profiles.active=$STAGE -jar /app/dispiele-backend.jar