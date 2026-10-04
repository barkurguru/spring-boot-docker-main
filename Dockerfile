FROM eclipse-temurin:17-jdk
EXPOSE 8080
ADD target/person-crud.jar personcrud.jar
ENTRYPOINT ["java", "-jar", "personcrud.jar"]