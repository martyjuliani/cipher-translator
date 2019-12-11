package com.juleq.ciphertranslator

import com.juleq.ciphertranslator.controller.CipherTranslatorController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class CipherTranslatorApplicationTest extends Specification {

    @Autowired (required = false)
    private CipherTranslatorController cipherTranslatorController

    def "when context is loaded then all expected beans are created"() {
        expect: "the CipherTranslatorController is created"
        cipherTranslatorController
    }
}