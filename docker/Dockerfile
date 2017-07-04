FROM openjdk:8u92-jre-alpine

RUN apk update && apk upgrade

WORKDIR /apps/garage

RUN adduser -D -s /bin/sh www \
    && chown www /apps/garage

USER www:www

# We add the feasibility ui jar to the image
ADD build/libs/garage-*.jar garage.jar

ENV PORT 8080
EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xms128m","-Xmx256m","-jar","garage.jar"]