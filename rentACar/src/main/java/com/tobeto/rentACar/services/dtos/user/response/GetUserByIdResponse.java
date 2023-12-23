package com.tobeto.rentACar.services.dtos.user.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserByIdResponse {

    private String name;

    private String surname;

    private String email;

    private LocalDate birthdate;

}
