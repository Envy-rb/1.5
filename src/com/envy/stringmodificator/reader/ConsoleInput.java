package com.envy.stringmodificator.reader;

import com.envy.stringmodificator.exception.CustomInvalidDataException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {
    private static final String STOP_FLAG = "###";

    public String readConsoleData() throws CustomInvalidDataException {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(String.format("flag of end inputting is %s", STOP_FLAG));

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while (true) {
                line = reader.readLine();

                if (line.equals(STOP_FLAG)) {
                    break;
                } else {
                    stringBuilder.append(line);
                }
            }
        } catch (IOException e) {
            throw new CustomInvalidDataException("Error while reading data from console", e);
        }

        return stringBuilder.toString();
    }
}
