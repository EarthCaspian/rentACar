package com.tobeto.rentACar.services.dtos.user.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersResponse {

    private String email;

    private String password;

}
