package com.juleq.ciphertranslator.backend.service.impl;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.juleq.ciphertranslator.backend.model.ConversionType;
import com.juleq.ciphertranslator.backend.model.MorseAlphabet;
import com.juleq.ciphertranslator.backend.service.CipherTranslatorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static java.lang.Character.isWhitespace;
import static java.lang.String.format;

/**
 * Service implementation to translate natural text to the corresponding Morse code representation.
 */
@Service
public class TextToMorseServiceImpl implements CipherTranslatorService {

    /**
     * Checks if the translation can be handled by this service.
     *
     * @param type the conversion type
     * @return true in case of the service can handle this type of translation
     */
    @Override
    public boolean canHandle(ConversionType type) {
        return type == ConversionType.TEXT_MORSE;
    }

    /**
     * Translates text to Morse code.
     *
     * @param text the input plain english text (punctuation is ignored)
     * @param wordSeparator the word separator to divide each single word
     * @return the translated Morse code
     */
    @Override
    public String translate(String text, Character wordSeparator) {
        return normalize(text).stream()
                .map(c -> isWhitespace(c) ? format("%s ", wordSeparator) : format("%s ", MorseAlphabet.getMorse(c)))
                .collect(Collectors.joining(""));
    }

    private static ImmutableList<Character> normalize(String text) {
        String normalized = StringUtils.stripAccents(text.toLowerCase());
        return Lists.charactersOf(normalized);
    }
}