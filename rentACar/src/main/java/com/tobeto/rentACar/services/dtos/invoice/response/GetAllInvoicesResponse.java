package com.tobeto.rentACar.services.dtos.invoice.response;

import com.tobeto.rentACar.services.dtos.rental.response.GetAllRentalsResponse;
import com.tobeto.rentACar.services.dtos.rental.response.GetRentalByIdResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInvoicesResponse {
    private Integer id;
    private String invoiceNo;
    private Float totalPrice;
    private Float discountRate;
    private Float taxRate;
    private GetRentalByIdResponse rental;
}
