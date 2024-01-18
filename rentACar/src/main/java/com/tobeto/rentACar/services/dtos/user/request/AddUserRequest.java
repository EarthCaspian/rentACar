package com.tobeto.rentACar.services.dtos.user.request;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {

    @NotBlank
    @Length(max = 40, message = "The email cannot exceed 40 characters!")
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$",
            message = "Geçerli bir e-posta adresi giriniz.")
    private String email;

    @NotBlank
    private String password;

}
