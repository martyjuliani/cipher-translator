package com.juleq.ciphertranslator.backend.service;

import com.juleq.ciphertranslator.backend.model.ConversionType;

public interface CipherTranslatorService {

    boolean canHandle(ConversionType type);

    String translate(String text, Character wordSeparator);
}