FROM openjdk:16-alpine3.13
COPY ./build/libs/warehouse_server-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
EXPOSE 8080
CMD ["java","-jar","app.jar"]
