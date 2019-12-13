package com.juleq.ciphertranslator;

import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@EnableVaadin
public class CipherTranslatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CipherTranslatorApplication.class, args);
    }
}
