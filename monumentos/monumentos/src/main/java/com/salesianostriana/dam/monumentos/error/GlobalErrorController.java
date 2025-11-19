package com.salesianostriana.dam.monumentos.error;

public class GlobalErrorController extends RuntimeException {
    public GlobalErrorController(String message) {
        super(message);
    }
}
