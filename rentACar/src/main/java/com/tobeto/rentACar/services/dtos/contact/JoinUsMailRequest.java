package com.tobeto.rentACar.services.dtos.contact;

import lombok.Data;

@Data
public class JoinUsMailRequest {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String message;
}
