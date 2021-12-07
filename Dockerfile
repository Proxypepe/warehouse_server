FROM openjdk:16-alpine3.13

COPY ./build/libs/warehouse_server-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

CMD ["java","-jar","app.jar"]
