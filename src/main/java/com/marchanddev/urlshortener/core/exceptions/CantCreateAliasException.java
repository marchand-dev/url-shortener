package com.marchanddev.urlshortener.core.exceptions;

import java.security.NoSuchAlgorithmException;

public class CantCreateAliasException extends NoSuchAlgorithmException {
    public CantCreateAliasException(String message) {
        super(message);
    }
}
