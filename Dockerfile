FROM openjdk:8
MAINTAINER Unlisted <rando@the-cloud.com>

#ADD target/m4server-0.1.0-SNAPSHOT-standalone.jar /m4server/app.jar
WORKDIR /m4server
#we have app.jar in the root directory, assuming we've run bundle.ps1/sh....
COPY . .

EXPOSE 4000

CMD ["java", "-jar", "app.jar"]
#CMD ["java", "-cp", "app.jar", "m4server.main"]
#CMD java -cp /m4server/app.jar clojure.main -e "(require 'm4server.core) (m4server.core/run-server)"

#CMD bash