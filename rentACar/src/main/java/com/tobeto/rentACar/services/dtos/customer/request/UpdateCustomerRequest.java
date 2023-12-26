package com.tobeto.rentACar.services.dtos.customer.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

    @NotNull
    @Positive(message = "The assigned value must not assume a negative numerical value!")
    private int id;

    @NotBlank(message = "Registration is not possible without a username!")
    @Length(max = 30, message = "The name cannot exceed 30 characters!")
    @Pattern(regexp = "^[A-Za-z\\s]*$",
            message = "Please use capital letters only, and avoid special characters!")
    private String firstName;

    @NotBlank
    @Length(max = 40, message = "The surname cannot exceed 40 characters!")
    @Pattern(regexp = "^[A-Za-z\\s]*$",
            message = "Please use capital letters only, and avoid special characters!")
    private String lastName;

    @NotNull(message = "Birthdate cannot be null!")
    @Past(message = "Birthdate must be in the past!")
    private LocalDate birthdate;

    @NotBlank
    @Length(max = 11, message = "The International ID cannot exceed 11 characters!")
    @Pattern(regexp = "^[0-9\\s]*$",
            message = "Please use numbers only, and avoid special characters and capital letters!")
    private String internationalId;

    @NotNull
    @Past(message = "Date must be in the past!")
    private LocalDate licenceIssueDate;

    @NotNull
    @Positive(message = "The assigned value must not assume a negative numerical value!")
    private int userId;

}
