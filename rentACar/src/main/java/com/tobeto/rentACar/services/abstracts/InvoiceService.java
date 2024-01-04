package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.invoice.request.AddInvoiceRequest;
import com.tobeto.rentACar.services.dtos.invoice.request.DeleteInvoiceRequest;
import com.tobeto.rentACar.services.dtos.invoice.request.UpdateInvoiceRequest;
import com.tobeto.rentACar.services.dtos.invoice.response.GetAllInvoicesResponse;
import com.tobeto.rentACar.services.dtos.invoice.response.GetInvoiceByIdResponse;

import java.util.List;

public interface InvoiceService {
    void add(AddInvoiceRequest request);
    void update(UpdateInvoiceRequest request);
    void delete(DeleteInvoiceRequest request);
    List<GetAllInvoicesResponse> getAll();
    GetInvoiceByIdResponse getById(int id);
}
