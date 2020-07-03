package com.envy.stringmodificator.service.impl.charset;

import com.envy.stringmodificator.exception.CustomInvalidDataException;
import com.envy.stringmodificator.service.ElementReplace;

public class CharElementReplaceImpl implements ElementReplace {
    private static final String REGEX_SEPARATOR = "\\b";

    @Override
    public String charReplacing(String text, int index, char replacement) throws CustomInvalidDataException {
        if (text == null || index <= 0 || replacement < 0) {
            throw new CustomInvalidDataException("Invalid data or null string");
        }
        StringBuffer buffer = new StringBuffer();
        String[] words = text.split(REGEX_SEPARATOR);

        for (String word : words) {
            char[] completeWord = new char[word.length()];
            if (word.length() >= index) {
                for (int i = 0; i < word.length(); i++) {
                    if (i + 1 == index) {
                        completeWord[i] = replacement;
                    } else {
                        completeWord[i] = word.charAt(i);
                    }
                }
            } else {
                buffer.append(word);
            }
            buffer.append(completeWord);
        }
        return buffer.toString();
    }

    @Override
    public String typoFixing(String text) throws CustomInvalidDataException {
        if (text == null) {
            throw new CustomInvalidDataException("Invalid data or null string");
        }

        char[] textAsArray = text.toCharArray();

        for (int i = 0; i < textAsArray.length - 1; i++) {
            if (textAsArray[i] == 'p' && textAsArray[i + 1] == 'a') {
                textAsArray[i + 1] = 'o';
                i++;//skipping check for 'o'letter;
            }
        }
        return String.valueOf(textAsArray);
    }

    @Override
    public String substringReplace(String text, int wordLength, String replacement) throws CustomInvalidDataException {
        if (text == null || wordLength <= 0 || replacement == null) {
            throw new CustomInvalidDataException("Invalid data or null string");
        }

        String[] words = text.split(REGEX_SEPARATOR);
        StringBuilder buffer = new StringBuilder();

        for (String word : words) {
            char[] wordChars = word.toCharArray();
            if (wordChars.length != wordLength) {
                buffer.append(wordChars);
            } else {
                buffer.append(replacement);
            }
        }

        return buffer.toString();
    }
}
