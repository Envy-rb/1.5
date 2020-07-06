package com.envy.stringmodificator.reader;

import com.envy.stringmodificator.exception.CustomInvalidDataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileInput {
    private static final String DEFAULT_PATH = "input/default.txt";

    public String readFileData() throws CustomInvalidDataException {
        Path path = Paths.get(DEFAULT_PATH);
        String dataLine;

        try {
            dataLine = Files.readString(path);
        } catch (IOException e) {
            throw new CustomInvalidDataException("Error while opening file", e);
        }

        return dataLine;
    }
}
