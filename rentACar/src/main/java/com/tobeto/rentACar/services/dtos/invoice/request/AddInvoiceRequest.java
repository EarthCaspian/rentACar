package com.tobeto.rentACar.services.dtos.invoice.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInvoiceRequest {

    @NotNull
    private String invoiceNo;

    @NotNull(message = "Total price cannot be null")
    @Min(value = 0, message = "Total price must be greater than or equal to 0")
    private Float totalPrice;

    @NotNull(message = "Discount rate cannot be null")
    @Min(value = 0, message = "Discount rate must be greater than or equal to 0")
    @Max(value = 100, message = "Discount rate cannot be greater than 100")
    private Float discountRate;

    @NotNull(message = "Tax rate cannot be null")
    @Min(value = 0, message = "Tax rate must be greater than or equal to 0")
    @Max(value = 100, message = "Tax rate cannot be greater than 100")
    private Float taxRate;

    @NotNull
    @Positive(message = "The assigned value must not assume a negative numerical value!")
    private int rentalId;

}
