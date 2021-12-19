FROM gradle
COPY . /app
WORKDIR /app
RUN gradle build
#COPY ./build/libs/warehouse_server-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080
CMD ["java","-jar","./build/libs/warehouse_server-0.0.1-SNAPSHOT.jar"]
