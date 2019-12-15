package com.juleq.ciphertranslator.backend.service


import com.juleq.ciphertranslator.backend.service.impl.TextToMorseServiceImpl
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

import static org.junit.jupiter.api.Assertions.assertThrows

@RunWith(MockitoJUnitRunner.class)
class TextToMorseServiceImplTest {

    @InjectMocks
    private TextToMorseServiceImpl textToMorseService

    @Test
    void 'translate text with single spaces'() {
        def text = 'english text to translate.'

        def result = textToMorseService.translate(text, '|' as char)

        assert result == ". -. --. .-.. .. ... .... | - . -..- - | - --- | - .-. .- -. ... .-.. .- - . .-.-.- "
    }

    @Test
    void 'translate text with more spaces'() {
        def text = 'two  three   four     '

        def result = textToMorseService.translate(text, '|' as char)

        assert result == "- .-- --- | | - .... .-. . . | | | ..-. --- ..- .-. | | | | | "
    }

    @Test
    void 'translate upper case text'() {
        def text = 'ENGLISH TEXT TO TRANSLATE.'

        def result = textToMorseService.translate(text, '|' as char)

        assert result == ". -. --. .-.. .. ... .... | - . -..- - | - --- | - .-. .- -. ... .-.. .- - . .-.-.- "
    }

    @Test
    void 'translate not recognized text'() {
        def text = 'Příliš žluťoučký kůň úpěl ďábelské ódy'

        def result = textToMorseService.translate(text, '|' as char)

        assert result == ".--. .-. .. .-.. .. ... | --.. .-.. ..- - --- ..- -.-. -.- -.-- | -.- ..- -. | ..- .--. . .-.. | -.. .- -... . .-.. ... -.- . | --- -.. -.-- "
    }

    @Test
    void 'do not translate text with illegal characters'() {
        assertThrows(IllegalArgumentException.class, { -> textToMorseService.translate("Æ¥£", '|' as char) }, "Illegal character provided.")
  }
}