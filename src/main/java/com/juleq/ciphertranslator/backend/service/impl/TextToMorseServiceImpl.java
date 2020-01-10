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

@Service
public class TextToMorseServiceImpl implements CipherTranslatorService {

    @Override
    public boolean canHandle(ConversionType type) {
        return type == ConversionType.TEXT_MORSE;
    }

    @Override
    public String translate(String plainText, Character wordSeparator) {
        return normalize(plainText).stream()
                .map(c -> isWhitespace(c) ? format("%s ", wordSeparator) : format("%s ", MorseAlphabet.getMorse(c)))
                .collect(Collectors.joining(""));
    }

    private static ImmutableList<Character> normalize(String plainText) {
        String normalized = StringUtils.stripAccents(plainText.toLowerCase());
        return Lists.charactersOf(normalized);
    }
}