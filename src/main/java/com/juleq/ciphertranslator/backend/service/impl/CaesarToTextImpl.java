package com.juleq.ciphertranslator.backend.service.impl;

import com.juleq.ciphertranslator.backend.model.ConversionType;
import com.juleq.ciphertranslator.backend.service.CipherTranslatorService;
import org.springframework.stereotype.Service;

@Service
public class CaesarToTextImpl implements CipherTranslatorService {

    @Override
    public boolean canHandle(ConversionType type) {
        return type == ConversionType.CAESAR_TEXT;
    }

    @Override
    public String translate(String text, Character wordSeparator) {
        return "CAESAR_TEXT";
    }
}
