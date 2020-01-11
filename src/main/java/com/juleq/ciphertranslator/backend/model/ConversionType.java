package com.juleq.ciphertranslator.backend.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ConversionType {
    TEXT_MORSE("Text to Morse code"),
    MORSE_TEXT("Morse code to text"),
    TEXT_CAESAR("Text to Caesar code"),
    CAESAR_TEXT("Caesar code to text");

    private final String name;

    ConversionType(String name) {
        this.name = name;
    }

    public static ConversionType fromName(String name) {
        return Arrays.stream(ConversionType.values())
                .filter(value -> value.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown type of conversion detected: '" + name + "'"));
    }

    public static List<String> getNames() {
        return Stream.of(ConversionType.values())
                .map(value -> value.name)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.name;
    }
}