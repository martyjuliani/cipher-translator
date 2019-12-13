# Cipher translator

An example for translate Morse cipher. Application is implemented with using Spring boot and Vaadin frameworks. The UI is built with Java only.

Source files are available on GitHub https://github.com/martyjuliani/cipher-translator.

## Prerequisites

The project can be imported into the IDE of your choice, with Java 11 installed, as a Maven project.

## Project Structure

The project is following the standard [Maven project layout](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html).
To compile the entire project, run "mvn clean install" in the project root.

## Public REST API
 - POST http://localhost:8080/cipher-translator/translations with request body with text to translate
 - GET http://localhost:8080/cipher-translator/translations 
  
## Running the project from command line

Run `mvn clean install spring-boot:run` in the project root directory. After the server has started point your browser to [http://localhost:8080/cipher-translator-ui](http://localhost:8080/cipher-translator-ui) to see the resulting application.

## Running the project from your IDE

Navigate to the `com.juleq.ciphertranslator.CipherTranslatorApplication.java` class and run it as a Java application.  

### Running tests

Tests are implemented using TestBench. The tests take a few minutes to run and are therefore included in a separate Maven profile. To run the tests using Google Chrome, execute

`mvn verify -Pit`

### Branching information:
* `master` the latest version of the application
