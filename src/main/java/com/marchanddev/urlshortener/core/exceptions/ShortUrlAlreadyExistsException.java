package com.marchanddev.urlshortener.core.exceptions;

public class ShortUrlAlreadyExistsException extends Exception {
    public ShortUrlAlreadyExistsException(String message) {
        super(message);
    }
}
