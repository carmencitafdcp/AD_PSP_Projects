package com.salesianostriana.dam.monumentos.error;

public class MonumentoNotFoundException extends RuntimeException {
    public MonumentoNotFoundException(String message) {
        super(message);
    }
}
