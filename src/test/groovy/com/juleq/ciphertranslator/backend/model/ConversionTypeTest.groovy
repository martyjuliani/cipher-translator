package com.juleq.ciphertranslator.backend.model

import spock.lang.Specification

import static com.juleq.ciphertranslator.backend.model.ConversionType.*

class ConversionTypeTest extends Specification {

    def "check conversion name with related type"(String name, ConversionType type) {
        expect:
        fromName(name) == type

        where:
        name                  | type
        "Text to Morse code"  | TEXT_MORSE
        "Morse code to text"  | MORSE_TEXT
        "Text to Caesar code" | TEXT_CAESAR
        "Caesar code to text" | CAESAR_TEXT
    }

    def "throw exception for unknown conversion name"() {
        when:
        fromName("Bad conversion")

        then:
        def ex = thrown(IllegalArgumentException)
        ex.message == "Unknown type of conversion detected: 'Bad conversion'"
    }

    def "get all available conversion names"() {
        expect:
        getNames() == ["Text to Morse code",  "Morse code to text", "Text to Caesar code", "Caesar code to text"]
    }
}