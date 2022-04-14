FROM openjdk:8
MAINTAINER Unlisted <rando@the-cloud.com>

ADD target/m4server-0.1.0-SNAPSHOT-standalone.jar /m4server/app.jar

EXPOSE 4000

CMD ["java", "-jar", "/m4server/app.jar"]