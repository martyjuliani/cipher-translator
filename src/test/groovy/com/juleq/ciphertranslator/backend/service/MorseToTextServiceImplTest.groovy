package com.juleq.ciphertranslator.backend.service

import com.juleq.ciphertranslator.backend.service.impl.MorseToTextServiceImpl
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

import static org.junit.jupiter.api.Assertions.assertThrows
import static org.mockito.MockitoAnnotations.initMocks

@RunWith(MockitoJUnitRunner.class)
class MorseToTextServiceImplTest {

    @InjectMocks
    private MorseToTextServiceImpl morseToTextService

    @BeforeMethod
    void init() {
        initMocks(this);
    }

    @Test
    void 'translate morse code to text'() {
        def morse = '. -. --. .-.. .. ... .... | - . -..- - | - --- | - .-. .- -. ... .-.. .- - . .-.-.-'

        def result = morseToTextService.translate(morse, '|' as char)

        assert result == "english text to translate."
    }

    @Test
    void 'do not translate unknown morse codes'() {
        assertThrows(IllegalArgumentException.class, { ->
            morseToTextService.translate("&......------", '|' as char) }, "Unknown morse code provided.")
    }
}