package com.tobeto.rentACar.services.dtos.invoice.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteInvoiceRequest {
    @NotNull
    @Positive(message = "The assigned value must not assume a negative numerical value!")
    private int id;

}
