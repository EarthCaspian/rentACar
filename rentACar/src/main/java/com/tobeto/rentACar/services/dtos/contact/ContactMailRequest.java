package com.tobeto.rentACar.services.dtos.contact;

import lombok.Data;

@Data
public class ContactMailRequest {
    private String name;
    private String surname;
    private String email;
    private String subject;
    private String message;


}
