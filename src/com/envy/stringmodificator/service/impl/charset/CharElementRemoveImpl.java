package com.envy.stringmodificator.service.impl.charset;

import com.envy.stringmodificator.exception.CustomInvalidDataException;
import com.envy.stringmodificator.service.ElementRemove;

public class CharElementRemoveImpl implements ElementRemove {
    private static final String REGEX_SEPARATOR = "\\b";
    private final static String WHITESPACE = " ";
    private static final String VOWELS = "aeiouyAEIOUY";

    @Override
    public String removeNonWhitespaceSymbols(String text) throws CustomInvalidDataException {
        if (text == null) {
            throw new CustomInvalidDataException("Invalid data or null string");
        }

        char[] textAsArray = text.toCharArray();
        StringBuilder result = new StringBuilder();

        for (char symbol : textAsArray) {
            if (Character.isLetterOrDigit(symbol) || Character.isWhitespace(symbol)) {
                result.append(symbol);
            } else {
                result.append(WHITESPACE);
            }
        }
        return result.toString();
    }

    @Override
    public String removeWordsByLength(String text, int wordLength) throws CustomInvalidDataException {
        if (text == null ||  wordLength <= 0) {
            throw new CustomInvalidDataException("Invalid data or null string");
        }

        String[] words = text.split(REGEX_SEPARATOR);
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            char[] wordAsArray = word.toCharArray();

            if (wordAsArray.length == wordLength && VOWELS.contains(String.valueOf(wordAsArray[0]))) {
                continue;
            } else {
                result.append(wordAsArray);
            }
        }

        return result.toString();
    }
}
