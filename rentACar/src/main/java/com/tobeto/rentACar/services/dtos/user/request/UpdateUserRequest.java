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
public class UpdateUserRequest {
    @NotNull
    @Positive
    private int id;

    @NotBlank(message = "Registration is not possible without a username!")
    @Length(max = 30, message = "The name cannot exceed 30 characters!")
    @Pattern(regexp = "^[A-Za-z\\s]*$",
            message = "Only include capital letters, special characters not allowed")
    private String name;

    @NotBlank
    @Length(max = 40, message = "The surname cannot exceed 40 characters!")
    @Pattern(regexp = "^[A-Za-z\\s]*$",
            message = "Only include capital letters, special characters not allowed")
    private String surname;

    @NotBlank
    @Length(max = 40, message = "The email cannot exceed 40 characters!")
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$", message = "Geçerli bir e-posta adresi giriniz.")
    private String email;

    @NotNull(message = "Birthdate cannot be null!")
    @Past(message = "Birthdate must be in the past!")
    private LocalDate birthdate;
}
