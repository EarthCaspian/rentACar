package com.tobeto.rentACar.core.utilities.exceptions.specificexceptions;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(String message) {
        super(message);
    }
}
