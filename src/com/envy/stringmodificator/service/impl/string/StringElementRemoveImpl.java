package com.envy.stringmodificator.service.impl.string;

import com.envy.stringmodificator.exception.CustomInvalidDataException;
import com.envy.stringmodificator.service.ElementRemove;

public class StringElementRemoveImpl implements ElementRemove {
    private final static String VOWELS = "AEIOUYaeiouy";
    private static final String NON_WHITESPACE_SYMBOLS = "[^a-zA-Z\\d\\s:]";
    private static final String WHITESPACE = " ";
    private static final String REGEX_SEPARATOR = "\\b";

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
            if (word.length() != wordLength) {
                bufferString.append(word);
            } else {
                if (VOWELS.contains(String.valueOf(word.charAt(0)))) {
                    bufferString.append(word);
                }
            }
        }

        return bufferString.toString();
    }
}