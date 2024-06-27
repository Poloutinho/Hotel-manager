package com.example.hotelmanager.exception;

public class NoAccessToBookException extends RuntimeException {
    public NoAccessToBookException(String message) {
        super(message);
    }
}
