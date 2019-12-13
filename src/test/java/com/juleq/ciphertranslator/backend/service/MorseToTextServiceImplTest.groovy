package com.juleq.ciphertranslator.backend.service

import com.juleq.ciphertranslator.backend.service.impl.MorseToTextServiceImpl
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

import static org.junit.jupiter.api.Assertions.assertThrows

@RunWith(MockitoJUnitRunner.class)
class MorseToTextServiceImplTest {

    @InjectMocks
    private MorseToTextServiceImpl morseToTextService

    @Test
    void 'translate morse code to text'() {
        def morse = '. -. --. .-.. .. ... .... | - . -..- - | - --- | - .-. .- -. ... .-.. .- - . .-.-.-'

        def result = morseToTextService.translate(morse)

        assert result == "english text to translate."
    }

    @Test
    void 'do not translate unknown morse codes'() {
        assertThrows(IllegalArgumentException.class, { -> morseToTextService.translate("&......------") }, "Unknown morse code provided.")
    }
}