package com.juleq.ciphertranslator.backend.service.impl;

import com.juleq.ciphertranslator.backend.model.ConversionType;
import com.juleq.ciphertranslator.backend.service.CipherTranslatorService;
import org.springframework.stereotype.Service;

@Service
public class TextToCaesarImpl implements CipherTranslatorService {

    @Override
    public boolean canHandle(ConversionType type) {
        return type == ConversionType.TEXT_CAESAR;
    }

    @Override
    public String translate(String text, Character wordSeparator) {
        return "TEXT_CAESAR";
    }
}