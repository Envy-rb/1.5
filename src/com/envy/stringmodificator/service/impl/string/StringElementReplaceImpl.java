package com.envy.stringmodificator.service.impl.string;

import com.envy.stringmodificator.exception.CustomInvalidDataException;
import com.envy.stringmodificator.service.ElementReplace;

public class StringElementReplaceImpl implements ElementReplace {
    private static final String REGEX_SEPARATOR = "\\b";
    private static final String WORD = "\\p{L}+";
    private static final String TYPO = "pa";
    private static final String CORRECT = "po";
    @Override
    public String charReplacing(String text, int index, char replacement) throws CustomInvalidDataException {
        if (text == null || index <= 0 || replacement < 0) {
            throw new CustomInvalidDataException("Invalid data or null string");
        }

        String[] words = text.split(REGEX_SEPARATOR);
        StringBuffer buffer;

        for (String word : words) {
            if (index <= word.length() && word.matches(WORD)) {
                buffer = new StringBuffer();
                buffer.append(word.substring(0, index - 1));
                buffer.append(replacement);
                buffer.append(word.substring(index));
                text = text.replace(word, buffer.toString());
            }
        }

        return text;
    }

    @Override
    public String typoFixing(String text) throws CustomInvalidDataException {
        if (text == null) {
            throw new CustomInvalidDataException("Invalid data or null string");
        }

        text = text.replace(TYPO, CORRECT);

        return text;
    }

    @Override
    public String substringReplace(String text, int wordLength, String replacement) throws CustomInvalidDataException {
        if (text == null || wordLength <= 0 || replacement == null) {
            throw new CustomInvalidDataException("Invalid data or null string");
        }

        String[] words = text.split(REGEX_SEPARATOR);

        for (String word : words) {
            if (word.length() == wordLength &&word.matches(WORD)) {
                text = text.replace(word, replacement);
            }
        }

        return text;
    }
}
