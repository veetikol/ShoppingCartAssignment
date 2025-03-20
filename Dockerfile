FROM maven:latest
WORKDIR /app
COPY . /app
ENTRYPOINT ["java", "-jar", "shoppingcart.jar"]