package com.juleq.ciphertranslator.backend.service.impl;

import com.juleq.ciphertranslator.backend.model.ConversionType;
import com.juleq.ciphertranslator.backend.model.MorseAlphabet;
import com.juleq.ciphertranslator.backend.service.CipherTranslatorService;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;

/**
 * Service implementation to translate Morse code to the corresponding text representation.
 */
@Service
public class MorseToTextServiceImpl implements CipherTranslatorService {

    private static final Pattern morseDelimiter = Pattern.compile("\\s+");

    /**
     * Checks if the translation can be handled by this service.
     *
     * @param type the conversion type
     * @return true in case of the service can handle this type of translation
     */
    @Override
    public boolean canHandle(ConversionType type) {
        return type == ConversionType.MORSE_TEXT;
    }

    /**
     * Translates Morse code to the text representation.
     *
     * @param morse the input Morse code as a string
     * @param wordSeparator the word separator to separate each single word
     * @return the translated Morse code
     */
    @Override
    public String translate(String morse, Character wordSeparator) {
        return morseDelimiter.splitAsStream(morse)
                .map(m -> valueOf(MorseAlphabet.getText(m)))
                .collect(Collectors.joining(""));
    }
}