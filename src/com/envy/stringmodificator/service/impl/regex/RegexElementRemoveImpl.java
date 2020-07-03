package com.envy.stringmodificator.service.impl.regex;

import com.envy.stringmodificator.exception.CustomInvalidDataException;
import com.envy.stringmodificator.service.ElementRemove;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexElementRemoveImpl implements ElementRemove {

    private static final String NON_WHITESPACE_SYMBOLS = "[^a-zA-Z\\d\\s:]";
    private static final String WHITESPACE = " ";
    private static final String WORDS_BY_LENGTH_STRATING_AT_VOWEL = "\\b[AEIOUYaeiouy][^\\W\\d]{%d}\\b";
    private static final String BLANK = "";

    @Override
    public String removeNonWhitespaceSymbols(String text) throws CustomInvalidDataException {
        if (text == null) {
            throw new CustomInvalidDataException("Invalid data or null string");
        }

        Pattern pattern = Pattern.compile(NON_WHITESPACE_SYMBOLS);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(WHITESPACE);

        return text;
    }

    @Override
    public String removeWordsByLength(String text, int wordLength) throws CustomInvalidDataException {
        if (text == null || wordLength <= 0) {
            throw new CustomInvalidDataException("Invalid data or null string");
        }

        Pattern pattern = Pattern.compile(String.format(WORDS_BY_LENGTH_STRATING_AT_VOWEL, wordLength - 1));
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(BLANK);

        return text;
    }
}