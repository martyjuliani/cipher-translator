package com.juleq.ciphertranslator.service

import com.juleq.ciphertranslator.service.impl.TextToMorseServiceImpl
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class TextToMorseServiceImplTest {

    @InjectMocks
    private TextToMorseServiceImpl textToMorseService

    @Test
    void 'translate text to morse code'() {
        def text = 'english text to translate.'

        def result = textToMorseService.translate(text)

        assert result == ". -. --. .-.. .. ... .... |- . -..- - |- --- |- .-. .- -. ... .-.. .- - . .-.-.- "
    }
}