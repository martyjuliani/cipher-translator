package com.juleq.ciphertranslator.backend.controller;

import com.juleq.ciphertranslator.backend.model.ConversionType;
import com.juleq.ciphertranslator.backend.service.CipherTranslatorFactory;
import com.juleq.ciphertranslator.backend.service.CipherTranslatorService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cipher-translator")
public class CipherTranslatorController {

    private CipherTranslatorFactory cipherTranslatorFactory;

    public CipherTranslatorController(CipherTranslatorFactory cipherTranslatorFactory) {
        this.cipherTranslatorFactory = cipherTranslatorFactory;
    }

    /**
     * REST API for retrieve all translation types.
     * Example: GET http://localhost:8080/cipher-translator/translations
     *
     * @return the list of all available translation types with Http status 200 OK or 500 in case of any error
     */
    @GetMapping(value = "/translations", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<String> getTranslationTypes() {
        return ConversionType.getNames();
    }

    /**
     * REST API for code translation.
     * Example: POST http://localhost:8080/cipher-translator/translations/Text%20to%20Morse%20code
     *
     * @param text the original text to translate
     * @param type the conversion type
     * @param wordSeparator the character to separate individual words
     * @return the translated text according to type with Http status 200 OK or 500 in case of any error
     */
    @PostMapping(value = "/translations/{type}", produces = {MediaType.TEXT_PLAIN_VALUE}, consumes = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> translate(
            @RequestBody String text,
            @PathVariable("type") String type,
            @RequestParam(defaultValue = "|") Character wordSeparator) {

        CipherTranslatorService service = cipherTranslatorFactory.getService(ConversionType.fromName(type));
        String translation = service.translate(text, wordSeparator);
        return ResponseEntity.ok(translation);
    }
}