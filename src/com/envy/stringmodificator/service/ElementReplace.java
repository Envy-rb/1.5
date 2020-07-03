package com.envy.stringmodificator.service;

import com.envy.stringmodificator.exception.CustomInvalidDataException;

public interface ElementReplace {

    public String charReplacing(String text, int index, char replacement) throws CustomInvalidDataException;

    public String typoFixing(String text) throws CustomInvalidDataException;

    public String substringReplace(String text, int wordLength, String replacement) throws CustomInvalidDataException;
}
