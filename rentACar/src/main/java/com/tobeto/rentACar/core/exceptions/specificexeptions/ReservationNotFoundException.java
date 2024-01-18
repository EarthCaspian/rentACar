package com.tobeto.rentACar.core.exceptions.specificexeptions;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(String message) {
        super(message);
    }
}
