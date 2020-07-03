package com.envy.stringmodificator.exception;


public class CustomInvalidDataException extends Exception{

    public CustomInvalidDataException() {
        super();
    }

    public CustomInvalidDataException(String message) {
        super(message);
    }

    public CustomInvalidDataException(String message, Throwable  cause) {
        super(message, cause);
    }

    public CustomInvalidDataException(Throwable cause) {
        super(cause);
    }
}
