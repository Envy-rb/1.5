package com.envy.stringmodificator.service.impl.string;

import com.envy.stringmodificator.exception.CustomInvalidDataException;
import com.envy.stringmodificator.service.ElementRemove;

public class StringElementRemoveImpl implements ElementRemove {
    private final static String VOWELS = "AEIOUYaeiouy";
    private static final String NON_WHITESPACE_SYMBOLS = "[^a-zA-Z\\d\\s:]";
    private static final String WHITESPACE = " ";
    private static final String REGEX_SEPARATOR = "\\b";
    private static final String WORD_LENGTH = "\\p{L}{%d}";

    @Override
    public String removeNonWhitespaceSymbols(String text) throws CustomInvalidDataException {
        if (text == null) {
            throw new CustomInvalidDataException("Invalid data or null string");
        }

        text = text.replaceAll(NON_WHITESPACE_SYMBOLS, WHITESPACE);

        return text;
    }

    @Override
    public String removeWordsByLength(String text, int wordLength) throws CustomInvalidDataException {
        if (text == null || wordLength <= 0) {
            throw new CustomInvalidDataException("Invalid data or null string");
        }

        StringBuilder bufferString = new StringBuilder();
        String[] separateText = text.split(REGEX_SEPARATOR);

        for (String word : separateText) {
            if (word.length() != wordLength || !word.matches(String.format(WORD_LENGTH, wordLength))) {
                bufferString.append(word);
            } else {
                if (VOWELS.contains(String.valueOf(word.charAt(0)))) {
                    continue;
                }
            }
        }

        return bufferString.toString();
    }
}