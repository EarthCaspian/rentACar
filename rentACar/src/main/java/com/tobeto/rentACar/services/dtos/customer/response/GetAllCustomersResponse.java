package com.tobeto.rentACar.services.dtos.customer.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCustomersResponse {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String internationalId;
    private LocalDate licenceIssueDate;
}
