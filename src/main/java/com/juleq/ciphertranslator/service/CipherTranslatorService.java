package com.juleq.ciphertranslator.service;

import com.juleq.ciphertranslator.model.ConversionType;

public interface CipherTranslatorService {

    boolean canHandle(ConversionType type);

    String translate(String text);
}