package com.juleq.ciphertranslator.service

import com.juleq.ciphertranslator.service.impl.MorseToTextServiceImpl
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class MorseToTextServiceImplTest {

    @InjectMocks
    private MorseToTextServiceImpl morseToTextService

    @Test
    void 'translate morse code to text'() {
        def morse = '. -. --. .-.. .. ... .... - . -..- - - --- - .-. .- -. ... .-.. .- - . .-.-.-'

        def result = morseToTextService.translate(morse)

        assert result == "englishtexttotranslate."
    }
}