# Integer to Roman converter service
This service implements the REST APIs to convert the input integer to roman equivalent.
Service is implemented  using Spring Boot 2 framework.

### Following Apis are supported:

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

### How to build this project?
#### Follow the below steps to run this project on local.

1. Run `mvn clean compile test` this step will compile the project and run the unit test cases
2. Run `mvn clean install` this step will generate `converter-0.0.1-SNAPSHOT.jar` file under `target` directory of main project
3. Run `java -jar target/converter-0.0.1-SNAPSHOT.jar` this step will start the local server and now you can send GET requests mentioned above


#### Follow the below steps to run this project using docker
1. Run `mvn clean compile test` this step will compile the project and run the unit test cases
2. Run `mvn clean install` this step will generate `converter-0.0.1-SNAPSHOT.jar` file under `target` directory of main project
3. Run `docker build -t springio/gs-spring-boot-docker . ` this step will create the docker image
4. Run `docker run -p 8080:8080 springio/gs-spring-boot-docker` this step will start docker container. Now, you can send the above mentioned requests

### Testing methods
This project has following type of tests

#### Integration test
    Integration test functions tests the controller layer functions by sending the HTTP requests

#### Unit test
    Unit test functions tests the service layer functions

### Package layout
This project has following package structure

* com.org.converter: Parent package
  * com.org.converter.controller: Consists of REST controllers
  * com.org.converter.exception: Consists of exception handler
  * com.org.converter.models: Consists of model classes
  * com.org.converter.service: Consists of service interface and implementation 
  * com.org.converter.util: Consists of util classes
  * Tests are present under test directory. Test package has sub-packages for unit and integration tests

### Dependencies
This project has following dependencies
* Spring boot starters : These are used to implement the REST API
* io.micrometer : Used to generate the metrics
* junit : Used to implement the test cases

### Error handling
This project uses Spring controller advice to implement the generic exception handler.

### Metrics and monitoring
This project uses Spring actuator to generate the metrics and monitoring end points. In addition to this, micrometer is used to major the time taken by methods in controller.

* Use this endpoint to get metrics : http://localhost:8080/actuator/prometheus 
* Use this endpoint to monitor application : http://localhost:8080/actuator/health
