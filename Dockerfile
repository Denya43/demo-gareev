FROM openjdk:8

WORKDIR /app

ADD target/demo-gareev-0.0.1-SNAPSHOT.jar .

CMD ["java", \
"-Duser.timezone=GMT+3:00", \
"-jar", "demo-gareev-0.0.1-SNAPSHOT.jar"]