# Cipher translator

An example of web application for translation Morse cipher. It is implemented with using Spring boot and Vaadin frameworks. 

Source files are available on GitHub https://github.com/martyjuliani/cipher-translator.

## Prerequisites

The project can be imported into the IDE of your choice as a Maven project with Java 11 installed.

## Project Structure

The project is following the standard [Maven project layout](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html).
To compile the entire project, run `mvn clean install` in the project root.

## Public REST API
 - POST http://localhost:8080/cipher-translator/translations with request body with text to translate
 - GET http://localhost:8080/cipher-translator/translations 
  
## Running the project from command line

Run `mvn clean install spring-boot:run` in the project root directory. After the server has started point your browser to [http://localhost:8080/cipher-translator-ui](http://localhost:8080/cipher-translator-ui) to see the resulting application.

## Running the project from your IDE

Navigate to the `com.juleq.ciphertranslator.CipherTranslatorApplication.java` class and run it as a Java application.  

## Running Tests

All tests are implemented by using Groovy, Mockito, Spock and TestNG.

Run `mvn test` from command line or use CipherTranslatorTest profile from the Configuration menu.

## Branching information:
* `master` the latest version of the application
