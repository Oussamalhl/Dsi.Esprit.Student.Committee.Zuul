FROM  maven:3-jdk-8
WORKDIR /Zuul
COPY . .
RUN mvn clean install
EXPOSE 8765

CMD mvn spring-boot:run