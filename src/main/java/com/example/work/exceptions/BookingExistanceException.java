package com.example.work.exceptions;

public class BookingExistanceException extends RuntimeException {

    public BookingExistanceException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public BookingExistanceException(String errorMessage) {
        super(errorMessage);
    }
}
