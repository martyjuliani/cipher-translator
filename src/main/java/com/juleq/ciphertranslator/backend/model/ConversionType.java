package com.juleq.ciphertranslator.backend.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Enum with all available conversion types.
 */
public enum ConversionType {
    TEXT_MORSE("Text to Morse code"),
    MORSE_TEXT("Morse code to text"),
    TEXT_CAESAR("Text to Caesar code"),
    CAESAR_TEXT("Caesar code to text");

    private final String name;

    ConversionType(String name) {
        this.name = name;
    }

    /**
     * Finds conversion type enum value from a string name representation.
     *
     * @param name the name of conversion in readable format
     * @return the conversion type enum value
     * @throws IllegalArgumentException if the name of the conversion is not supported
     */
    public static ConversionType fromName(String name) {
        return Arrays.stream(ConversionType.values())
                .filter(value -> value.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown type of conversion detected: '" + name + "'"));
    }

    /**
     * Gets all available conversion types as a string names.
     *
     * @return the list of conversion names
     */
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