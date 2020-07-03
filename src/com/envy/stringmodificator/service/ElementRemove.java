package com.envy.stringmodificator.service;

import com.envy.stringmodificator.exception.CustomInvalidDataException;

public interface ElementRemove {

    public String removeNonWhitespaceSymbols(String text) throws CustomInvalidDataException;

    public String removeWordsByLength(String text, int wordLength) throws CustomInvalidDataException;
}
