package com.juleq.ciphertranslator.backend.controller

import com.juleq.ciphertranslator.backend.model.ConversionType
import com.juleq.ciphertranslator.backend.service.CipherTranslatorFactory
import com.juleq.ciphertranslator.backend.service.CipherTranslatorService
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.http.HttpStatus
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

import static org.mockito.ArgumentMatchers.anyChar
import static org.mockito.ArgumentMatchers.anyString
import static org.mockito.Mockito.*
import static org.mockito.MockitoAnnotations.initMocks

@RunWith(MockitoJUnitRunner.class)
class CipherTranslatorControllerTest {

    @Mock
    private CipherTranslatorFactory factory
    @Mock
    private CipherTranslatorService service

    @InjectMocks
    private CipherTranslatorController controller

    @BeforeMethod
    void init() {
        initMocks(this);
    }

    @Test
    void 'check all available conversion types'() {
        def result = controller.getTranslationTypes()

        assert result == ["Text to Morse code", "Morse code to text", "Text to Caesar code", "Caesar code to text"]
    }

    @Test
    void 'check if translation is properly called'() {
        when(factory.getService(any(ConversionType.class))).thenReturn(service)
        when(service.translate(anyString(), anyChar())).thenReturn("translation")

        def result = controller.translate("Abrakadabra",  "Text to Morse code", '|' as Character)

        assert result.getStatusCode() == HttpStatus.OK
        assert result.getBody() == "translation"
        verify(factory).getService(any(ConversionType.class))
        verify(service).translate(anyString(), anyChar())
    }
}