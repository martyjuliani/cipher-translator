package com.juleq.ciphertranslator.backend.service;

import com.juleq.ciphertranslator.backend.model.ConversionType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Factory class for cipher translation.
 */
@Component
public class CipherTranslatorFactory {

    private final List<CipherTranslatorService> services;

    /**
     * Initialise all types of used translation services.
     * @param services the cipher translation service implementations
     */
    public CipherTranslatorFactory(List<CipherTranslatorService> services) {
        this.services = services;
    }

    /**
     * Return concrete service implementation according to conversion type.
     * @param type the conversion type which determines source and destination code
     * @return the cipher service which will be used to translation
     * @throws IllegalArgumentException if the unknown type of translation is detected
     */
    public CipherTranslatorService getService(ConversionType type) {
        return services.stream()
                .filter(service -> service.canHandle(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown type of translation detected: " + type.toString()));
    }
}