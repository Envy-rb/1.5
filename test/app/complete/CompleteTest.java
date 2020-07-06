package com.test.app.complete;

import com.envy.stringmodificator.exception.CustomInvalidDataException;
import com.envy.stringmodificator.reader.FileInput;
import com.envy.stringmodificator.service.impl.charset.CharElementRemoveImpl;
import com.envy.stringmodificator.service.impl.charset.CharElementReplaceImpl;
import com.envy.stringmodificator.service.impl.regex.RegexElementRemoveImpl;
import com.envy.stringmodificator.service.impl.regex.RegexElementReplaceImpl;
import com.envy.stringmodificator.service.impl.string.StringElementRemoveImpl;
import com.envy.stringmodificator.service.impl.string.StringElementReplaceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompleteTest {
    private FileInput inputData = new FileInput();

    private CharElementRemoveImpl charRemove = new CharElementRemoveImpl();
    private RegexElementRemoveImpl regexRemove = new RegexElementRemoveImpl();
    private StringElementRemoveImpl stringRemove = new StringElementRemoveImpl();

    private CharElementReplaceImpl charReplace = new CharElementReplaceImpl();
    private RegexElementReplaceImpl regexReplace = new RegexElementReplaceImpl();
    private StringElementReplaceImpl stringReplace = new StringElementReplaceImpl();

    private final static int WORD_LENGTH = 9;
    private final static int CHAR_INDEX = 2;
    private final static char REPLACE_CHAR = 'q';
    private final static String REPLACE_STRING = "TEST";

    private void AllAreEqual(String ... strings) {
        for (int i = 1; i < strings.length; i++) {
            Assertions.assertEquals(strings[0], strings[i]);
        }
    }

    @Test
    public void removeNonWhitespaceSymbolsTest() throws CustomInvalidDataException {
        String text = inputData.readFileData();
        String charResult = charRemove.removeNonWhitespaceSymbols(text);
        String regexResult = regexRemove.removeNonWhitespaceSymbols(text);
        String stringResult = stringRemove.removeNonWhitespaceSymbols(text);
        AllAreEqual(charResult, regexResult, stringResult);
    }

    @Test
    public void removeWordsByLengthTest() throws CustomInvalidDataException {
        String text = inputData.readFileData();
        String charResult = charRemove.removeWordsByLength(text, WORD_LENGTH);
        String regexResult = regexRemove.removeWordsByLength(text, WORD_LENGTH);
        String stringResult = stringRemove.removeWordsByLength(text, WORD_LENGTH);
        AllAreEqual(charResult, regexResult, stringResult);
    }

    @Test
    public void charReplacingTest() throws  CustomInvalidDataException {
        String text = inputData.readFileData();
        String charResult = charReplace.charReplacing(text, CHAR_INDEX, REPLACE_CHAR);
        String regexResult = regexReplace.charReplacing(text, CHAR_INDEX, REPLACE_CHAR);
        String stringResult = stringReplace.charReplacing(text, CHAR_INDEX, REPLACE_CHAR);
        AllAreEqual(charResult, regexResult, stringResult);
    }

    @Test
    public void typoFixingTest() throws CustomInvalidDataException {
        String text = inputData.readFileData();
        String charResult = charReplace.typoFixing(text);
        String regexResult = regexReplace.typoFixing(text);
        String stringResult = stringReplace.typoFixing(text);
        AllAreEqual(charResult, regexResult, stringResult);
    }
    
    @Test
    public void substringReplaceTest() throws CustomInvalidDataException {
        String text = inputData.readFileData();
        String charResult = charReplace.substringReplace(text, WORD_LENGTH, REPLACE_STRING);
        String regexResult = regexReplace.substringReplace(text, WORD_LENGTH, REPLACE_STRING);
        String stringResult = stringReplace.substringReplace(text, WORD_LENGTH, REPLACE_STRING);
        AllAreEqual(charResult, regexResult, stringResult);
    }
}