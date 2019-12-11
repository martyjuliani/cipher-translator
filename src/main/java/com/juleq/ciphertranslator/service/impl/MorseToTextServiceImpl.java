package com.juleq.ciphertranslator.service.impl;

import com.google.common.collect.BiMap;
import com.juleq.ciphertranslator.model.ConversionType;
import com.juleq.ciphertranslator.model.MorseAlphabet;
import com.juleq.ciphertranslator.service.CipherTranslatorService;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;

@Service
public class MorseToTextServiceImpl implements CipherTranslatorService {

    private static final BiMap<String, Character> morseMap = MorseAlphabet.morseMap;
    private static final Pattern morseDelimiter = Pattern.compile(" ");

    @Override
    public boolean canHandle(ConversionType type) {
        return type == ConversionType.MORSE_TEXT;
    }

    @Override
    public String translate(String morse) {
        return morseDelimiter.splitAsStream(morse)
                .map(m -> valueOf(morseMap.get(m)))
                .collect(Collectors.joining(""));
    }
}