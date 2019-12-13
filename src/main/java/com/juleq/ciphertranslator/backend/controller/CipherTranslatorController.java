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

    private final CipherTranslatorFactory cipherTranslatorFactory;

    public CipherTranslatorController(CipherTranslatorFactory cipherTranslatorFactory) {
        this.cipherTranslatorFactory = cipherTranslatorFactory;
    }

    @GetMapping(value = "/translations", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<String> getConversionTypes() {
        return ConversionType.getNames();
    }

    @PostMapping(value = "/translations/{type}", produces = {MediaType.TEXT_PLAIN_VALUE}, consumes = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> code(
            @RequestBody String text,
            @PathVariable("type") String type,
            @RequestParam(defaultValue = "|") Character wordSeparator) {

        CipherTranslatorService service = cipherTranslatorFactory.getService(ConversionType.fromName(type));
        String translation = service.translate(text, wordSeparator);
        return ResponseEntity.ok(translation);
    }
}