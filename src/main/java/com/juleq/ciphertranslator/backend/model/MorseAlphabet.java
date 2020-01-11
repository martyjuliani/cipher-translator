package com.juleq.ciphertranslator.backend.model;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

/**
 * Class for morse alphabet. Guava bidirectional map was used due to the reversed view and possibility to get the key
 * back from the related value.
 */
public class MorseAlphabet {

    private static BiMap<String, Character> morseMap;

    static {
        BiMap<String, Character> map = HashBiMap.create();
        fillMorseAlphabet(map);
        morseMap = Maps.unmodifiableBiMap(map);
    }

    /**
     * Gets a text representation of morse code.
     *
     * @param morse the morse string
     * @throws IllegalArgumentException if the specified morse code has no conversion defined
     */
    public static Character getText(String morse) {
        if (morseMap.get(morse) == null) {
            throw new IllegalArgumentException("Unknown morse code provided.");
        }
        return morseMap.get(morse);
    }

    /**
     * Gets a morse representation of one character.
     *
     * @param c the character from english alphabet
     * @throws IllegalArgumentException if the specified character has no morse code defined
     */
    public static String getMorse(Character c) {
        if (morseMap.inverse().get(c) == null) {
            throw new IllegalArgumentException("Unknown character provided.");
        }
        return morseMap.inverse().get(c);
    }

    private static void fillMorseAlphabet(BiMap<String, Character> map) {
        map.put("|", ' ');
        map.put(".-", 'a');
        map.put(".-.-", 'ä');
        map.put(".--.-", 'á');
        map.put("..-..", 'é');
        map.put("--.--", 'ñ');
        map.put("---.", 'ö');
        map.put("..--", 'ü');
        map.put("-...", 'b');
        map.put("-.-.", 'c');
        map.put("-..", 'd');
        map.put(".", 'e');
        map.put("..-.", 'f');
        map.put("--.", 'g');
        map.put("....", 'h');
        map.put("..", 'i');
        map.put(".---", 'j');
        map.put("-.-", 'k');
        map.put(".-..", 'l');
        map.put("--", 'm');
        map.put("-.", 'n');
        map.put("---", 'o');
        map.put(".--.", 'p');
        map.put("--.-", 'q');
        map.put(".-.", 'r');
        map.put("...", 's');
        map.put("-", 't');
        map.put("..-", 'u');
        map.put("...-", 'v');
        map.put(".--", 'w');
        map.put("-..-", 'x');
        map.put("-.--", 'y');
        map.put("--..", 'z');
        map.put("-----", '0');
        map.put(".----", '1');
        map.put("..---", '2');
        map.put("...--", '3');
        map.put("....-", '4');
        map.put(".....", '5');
        map.put("-....", '6');
        map.put("--...", '7');
        map.put("---..", '8');
        map.put("----.", '9');
        map.put(".-...", '&');
        map.put(".----.", '\'');
        map.put(".--.-.", '@');
        map.put("-.--.-", ')');
        map.put("-.--.", '(');
        map.put("---...", ':');
        map.put("--..--", ',');
        map.put("-...-", '=');
        map.put("-.-.--", '!');
        map.put(".-.-.-", '.');
        map.put("-....-", '-');
        map.put(".-.-.", '+');
        map.put(".-..-.", '\"');
        map.put("..--..", '?');
        map.put("...-..-", '$');
        map.put("-.-.-.", ';');
        map.put("..--.-", '_');
        map.put("-..-.", '/');
        map.put("--...-", '¡');
        map.put("..-.-", '¿');
    }
}