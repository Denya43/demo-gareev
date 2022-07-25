package com.example.demogareev.exception;

public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}
