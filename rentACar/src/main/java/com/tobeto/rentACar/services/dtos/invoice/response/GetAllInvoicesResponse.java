package com.tobeto.rentACar.services.dtos.invoice.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInvoicesResponse {
    private String invoiceNo;
    private Float totalPrice;
    private Float discountRate;
    private Float taxRate;
}
