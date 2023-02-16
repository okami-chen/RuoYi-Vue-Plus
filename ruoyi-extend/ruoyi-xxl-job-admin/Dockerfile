FROM openjdk:8

MAINTAINER chendehua

RUN mkdir -p /ruoyi/xxljob/logs

WORKDIR /ruoyi/xxljob

ENV TZ=PRC

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENV SERVER_PORT=9100 \
    SERVER_ENV=prod \
    SERVER_DEBUG=false \
    SERVER_TTL=3600

EXPOSE ${SERVER_PORT}

ADD ./target/ruoyi-xxl-job-admin.jar ./app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
