package com.juleq.ciphertranslator.service;

import com.juleq.ciphertranslator.model.ConversionType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CipherTranslatorFactory {

    private final List<CipherTranslatorService> services;

    public CipherTranslatorFactory(List<CipherTranslatorService> services) {
        this.services = services;
    }

    public CipherTranslatorService getService(ConversionType type) {
        return services.stream()
                .filter(service -> service.canHandle(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown type of translation detected: " + type.toString()));
    }
}