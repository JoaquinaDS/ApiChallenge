# Java Project with Hexagonal Architecture

This project implements a hexagonal architecture in Java, using H2 as an in-memory database and JaCoCo for test coverage.

## General info

Application that obtains the final price (pvp) and the rate that is applied to a certain product of a brand between
certain dates.

The result obtained is the brand, the product, the final price (PVP), the percentage increase and the start and end
dates.

In case there is more than one result for a date, product and brand, the selected one is the one with greater priority.

## Requirements

For building and running the application you need:

- **JDK 21.0.6**
- **MAVEN 3.8.6**


## Technologies Used
- **Java**
- **Spring Boot**
- **Hexagonal Architecture**
- **H2 Database**
- **JaCoCo** for test coverage
- **Mockito**
- **MapStruct**
- **Lombok**

## Accessing the Database
The project uses **H2 Database** in memory. To access the H2 web console, follow these steps:

1. Start the application.
2. Open your browser and go to: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
3. Use the following credentials:
    - **Username:** `joaquina`
    - **Password:** `disarro`

## Test Coverage with JaCoCo
JaCoCo is used to measure code coverage in unit tests. To generate and view the coverage report, follow these steps:

### Run tests and generate the report:

 ```sh
 mvn clean test
 mvn jacoco:report
 ```

### View the results:

1. After running the above commands, open the following file in your browser:
   ```
   target/site/jacoco/index.html
   ```
2. A detailed report with code coverage will be displayed.

## Running the application locally

### Steps to run

1. Build the project using
 ```sh
 mvn clean install
 ```
2. Run using
 ```sh
 mvn mvn spring-boot:run
 ```
or execute the `main` method in the `DemoApplication` class from your IDE

3. The web application is accesible via `http://localhost:8080`.