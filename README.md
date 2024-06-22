## General Info
Backend of web application about campanies of the products. It serves CRUD operations with data validations. There is implemented the REST API to deploy the frontend.  

## Technologies:

**Backend:** Java, SpringBoot, Hibernate

**Databese:** H2

## System Requirements:

- Java 8 or higher
- H2 (remote service)

  ## Setup
**Clone the Repository**

Clone the repository or download the source code:
```
git clone <https://github.com/MaciejBabicki/Product-Campaign.git>
```
**Download External Libraries**

This project uses external libraries such as Spring Boot and Hibernate. Ensure that you have Maven installed, then navigate to the project directory and run:
```
mvn clean install
```
This command will download all required dependencies and build the project.

**Set Up the Database**
Open the http://localhost:8080/h2-console and find the URL in logs after running java programm.

**Run the Application**

Once the database is set up and the project is built, you can run the application using the following command:
```
mvn spring-boot:run
```
This will start the Spring Boot application.

**Access the Application**

Once the application is running, you can access it at http://localhost:8080/campains in your web browser.

**Unit Tests**

The project includes unit tests. You can run them using Maven:
```
mvn test
```
