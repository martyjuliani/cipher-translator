package com.juleq.ciphertranslator.service.impl;

import com.juleq.ciphertranslator.model.ConversionType;
import com.juleq.ciphertranslator.service.CipherTranslatorService;
import org.springframework.stereotype.Service;

@Service
public class TextToCaesarImpl implements CipherTranslatorService {

    @Override
    public boolean canHandle(ConversionType type) {
        return type == ConversionType.TEXT_CAESAR;
    }

    @Override
    public String translate(String text) {
        return "TEXT_CAESAR";
    }
}