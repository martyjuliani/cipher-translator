package com.juleq.ciphertranslator.backend.service.impl;

import com.juleq.ciphertranslator.backend.model.ConversionType;
import com.juleq.ciphertranslator.backend.service.CipherTranslatorService;
import org.springframework.stereotype.Service;

import static java.lang.Character.*;

/**
 * Service implementation to translate natural text to the corresponding Caesar code representation.
 */
@Service
public class TextToCaesarServiceImpl implements CipherTranslatorService {

    /**
     * Checks if the translation can be handled by this service.
     *
     * @param type the conversion type
     * @return true in case of the service can handle this type of translation
     */
    @Override
    public boolean canHandle(ConversionType type) {
        return type == ConversionType.TEXT_CAESAR;
    }

    /**
     * Translates text to Caesar code. Processes only letters, rest of characters keep without change. White spaces are
     * replaced by the word separator.
     *
     * @param text the input plain english text (punctuation is ignored)
     * @param wordSeparator the word separator to divide each single word
     * @return the translated Caesar code
     */
    @Override
    public String translate(String text, Character wordSeparator) {
        StringBuilder strBuilder = new StringBuilder();
        int shift = 3;
        char code;
        for (var i = 0; i < text.length(); i++) {
            char charAt = text.charAt(i);
            code = isWhitespace(charAt) ? wordSeparator : charAt;
            if (isLetter(code)) {
                code = (char) (charAt + shift);
                if ((isLowerCase(charAt) && code > 'z') || (isUpperCase(charAt) && code > 'Z')) {
                    code = (char) (charAt - (26 - shift));
                }
            }
            strBuilder.append(code);
        }
        return strBuilder.toString();
    }
}