package com.example.work.exceptions;

public class ParameterException extends RuntimeException {

    public ParameterException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public ParameterException(String errorMessage) {
        super(errorMessage);
    }
}
