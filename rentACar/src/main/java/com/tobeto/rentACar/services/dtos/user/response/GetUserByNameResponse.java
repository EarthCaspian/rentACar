package com.tobeto.rentACar.services.dtos.user.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserByNameResponse {

    private int id;

    private String email;

    private String password;
}
