package com.envy.stringmodificator.service.impl.regex;

import com.envy.stringmodificator.exception.CustomInvalidDataException;
import com.envy.stringmodificator.service.ElementReplace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexElementReplaceImpl implements ElementReplace {
    private static final String GROUP_WORDS_BY_LENGTH = "\\b(\\S{%d})(\\S)(\\S*)\\b";
    private static final String WORDS_BY_LENGTH = "\\b\\S{%d}\\b";
    private static final String CHAR_REPLACE = "$1%s$3";
    private static final String TYPOS = "\\b(\\S+)([p])([a])";
    private static final String TYPO_REPLACE = "$1$2o";

    @Override
    public String charReplacing(String text, int index, char replacement) throws CustomInvalidDataException {
        if (text == null || index <= 0 || replacement < 0) {
            throw new CustomInvalidDataException("Invalid data or null string");
        }

        Pattern pattern = Pattern.compile(String.format(GROUP_WORDS_BY_LENGTH, index));
        Matcher matcher = pattern.matcher(text);
        String replacer = String.format(CHAR_REPLACE, replacement);
        text = matcher.replaceAll(replacer);
        return text;

    }

    @Override
    public String typoFixing(String text) throws CustomInvalidDataException {
        if (text == null) {
            throw new CustomInvalidDataException("Invalid data or null string");
        }
        Pattern pattern = Pattern.compile(TYPOS);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(TYPO_REPLACE);
        return text;
    }

    @Override
    public String substringReplace(String text, int wordLength, String replacement) throws CustomInvalidDataException {
        if (text == null || wordLength <= 0 || replacement == null) {
            throw new CustomInvalidDataException("Invalid data or null string");
        }

        Pattern pattern = Pattern.compile(String.format(WORDS_BY_LENGTH, wordLength));
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(replacement);

        return text;
    }
}
