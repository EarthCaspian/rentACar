package com.tobeto.rentACar.services.dtos.user.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserRequest {

    private int id;
    private String email;
    private String password;
}
