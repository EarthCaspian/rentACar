package com.tobeto.rentACar.core.exceptions.types;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }

}