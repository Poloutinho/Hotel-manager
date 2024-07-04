package com.example.hotelmanager.exception;

public class BookingNotAllowedException extends RuntimeException {
    public BookingNotAllowedException(String message) {
        super(message);
    }
}
