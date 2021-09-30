# Integer to Roman converter service
This service implements the REST APIs to convert the input integer to roman equivalent.
Service is implemented  using Spring Boot 2 framework.

###Following are the APIS supported:

Request: GET http://localhost:8080/converter/v1/romannumeral?query=100
Response:
```
{"conversion":[{"input":"100","output":"C"}]}
```

Request: GET http://localhost:8080/converter/v1/romannumeral?min=1&max=15
Response:
```
{"conversion":[{"input":"1","output":"I"},{"input":"2","output":"II"},{"input":"3","output":"III"},{"input":"4","output":"IV"},{"input":"5","output":"V"},{"input":"6","output":"VI"},{"input":"7","output":"VII"},{"input":"8","output":"VIII"},{"input":"9","output":"IX"},{"input":"10","output":"X"},{"input":"11","output":"XI"},{"input":"12","output":"XII"},{"input":"13","output":"XIII"},{"input":"14","output":"XIV"},{"input":"15","output":"XV"}]}
```

###How to build this project?
Follow the below steps to run this project on local.

1. Run `mvn clean compile test` this step will compile the project and run the unit test cases
2. Run `mvn clean install` this step will generate `converter-0.0.1-SNAPSHOT.jar` file under `target` directory of main project
3. Run `java -jar target/converter-0.0.1-SNAPSHOT.jar` this step will start the local server and now you can send GET requests mentioned above


Follow the below steps to run this project using docker
1. Run `mvn clean compile test` this step will compile the project and run the unit test cases
2. Run `mvn clean install` this step will generate `converter-0.0.1-SNAPSHOT.jar` file under `target` directory of main project
3. Run `docker build -t springio/gs-spring-boot-docker . ` this step will create the docker image
4. Run `docker run -p 8080:8080 springio/gs-spring-boot-docker` this step will start docker container. Now, you can send the above mentioned requests

