# Enviro File Converter SpringBoot Application

A SpringBoot web api application that interprets csv files and persists them into a database. The api defined endpoint returns a desired flat file based on name and surname.

## Project Scenario

You are joining a data centre division for Enviro-Bank:

This division receives a flat file that contains name, surname, imageFormat and imageData.
The image in the file is currently shared as a base64 encoded image data.

## How to Get Started

>This document provides instructions on how to clone the Spring Boot project, run tests, and execute the service.

### Cloning the Project

1. Open your terminal or command prompt.
2. Change the directory to the location where you want to clone the project.
3. Run the following command:

```bash
git clone https://github.com/lizerdingaan/Enviro-Bank_FileConverter.git
```

4. Once the cloning is complete, navigate into the project directory using the following command:

```bash
cd Enviro-Bank_FileConverter
```

### Running Tests

To run tests for the Spring Boot project, ensure that you have Maven installed. If you don't have Maven, you can download it from the official website: https://maven.apache.org/.

Once you have Maven installed, follow these steps to run the tests:

```bash
mvn test
```

### Executing the Service

To execute the Spring Boot service, follow these steps:

Open your terminal or command prompt.

```bash
mvn spring-boot:run
```

## Conclusion

You have successfully cloned the Spring Boot project, ran tests, and executed the service. Now you can explore the functionality of the service and make any necessary modifications for your specific use case.

### Improvements to be Made

- Introducing more objects
- Decoupling the `parseCsv()` method. The method is too big and is impossible to test
- Providing a proper error messages for other failures that may occur 