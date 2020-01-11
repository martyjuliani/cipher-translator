package com.juleq.ciphertranslator.backend.controller;

import com.juleq.ciphertranslator.CipherTranslatorApplication;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;

@SpringBootTest(classes = CipherTranslatorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class CipherTranslatorIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetTranslations() {
        List<String> expected = asList("Text to Morse code", "Morse code to text", "Text to Caesar code", "Caesar code to text");

        ResponseEntity<String[]> responseEntity = restTemplate
                .getForEntity("http://localhost:" + port + "/cipher-translator/translations", String[].class);

        List<String> result = asList(requireNonNull(responseEntity.getBody()));
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(result, expected);
    }

    @Test
    void testPostTextToMorse() {
        String text = "english text to translate.";
        String expected = ". -. --. .-.. .. ... .... | - . -..- - | - --- | - .-. .- -. ... .-.. .- - . .-.-.- ";
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/cipher-translator/translations/Text to Morse code", text, String.class);

        String result = responseEntity.getBody();
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(result, expected);
    }

    @Test
    void testPostMorseToText() {
        String morse = ". -. --. .-.. .. ... .... | - . -..- - | - --- | - .-. .- -. ... .-.. .- - . .-.-.- ";
        String expected = "english text to translate.";
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/cipher-translator/translations/Morse code to text", morse, String.class);

        String result = responseEntity.getBody();
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(result, expected);
    }
}