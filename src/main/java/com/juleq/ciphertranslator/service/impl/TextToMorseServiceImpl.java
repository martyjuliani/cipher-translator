package com.juleq.ciphertranslator.service.impl;

import com.google.common.collect.BiMap;
import com.google.common.collect.Lists;
import com.juleq.ciphertranslator.model.ConversionType;
import com.juleq.ciphertranslator.model.MorseAlphabet;
import com.juleq.ciphertranslator.service.CipherTranslatorService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TextToMorseServiceImpl implements CipherTranslatorService {

    private static final Character TEXT_WORD_DELIMITER = ' ';
    private static final String MORSE_WORD_DELIMITER = "|";
    private static final String MORSE_SIGN_DELIMITER = " ";

    private BiMap<Character, String> morseMap = MorseAlphabet.morseMap.inverse();

    @Override
    public boolean canHandle(ConversionType type) {
        return type == ConversionType.TEXT_MORSE;
    }

    @Override
    public String translate(String text) {
        return Lists.charactersOf(text).stream()
                .map(c -> c == TEXT_WORD_DELIMITER ? MORSE_WORD_DELIMITER : morseMap.get(c) + MORSE_SIGN_DELIMITER)
                .collect(Collectors.joining(""));
    }
}