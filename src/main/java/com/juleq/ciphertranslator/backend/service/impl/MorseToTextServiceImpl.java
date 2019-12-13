package com.juleq.ciphertranslator.backend.service.impl;

import com.juleq.ciphertranslator.backend.model.ConversionType;
import com.juleq.ciphertranslator.backend.model.MorseAlphabet;
import com.juleq.ciphertranslator.backend.service.CipherTranslatorService;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;

@Service
public class MorseToTextServiceImpl implements CipherTranslatorService {

    private static final Pattern morseDelimiter = Pattern.compile("\\s+");

    @Override
    public boolean canHandle(ConversionType type) {
        return type == ConversionType.MORSE_TEXT;
    }

    @Override
    public String translate(String morse, Character wordSeparator) {
        return morseDelimiter.splitAsStream(morse)
                .map(m -> valueOf(MorseAlphabet.getText(m)))
                .collect(Collectors.joining(""));
    }
}