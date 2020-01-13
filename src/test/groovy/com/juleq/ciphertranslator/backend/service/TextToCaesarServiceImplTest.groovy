package com.juleq.ciphertranslator.backend.service

import com.juleq.ciphertranslator.backend.service.impl.TextToCaesarServiceImpl
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

import static org.mockito.MockitoAnnotations.initMocks

@RunWith(MockitoJUnitRunner.class)
class TextToCaesarServiceImplTest {

    @InjectMocks
    private TextToCaesarServiceImpl textToCaesarService

    @BeforeMethod
    void init() {
        initMocks(this)
    }

    @Test
    void 'test text to caesar code translation'() {
        def text = 'English text to translate.'

        def result = textToCaesarService.translate(text, ' ' as Character)

        assert result == "Hqjolvk whaw wr wudqvodwh."
    }
}