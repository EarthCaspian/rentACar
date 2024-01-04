package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.InvoiceService;
import com.tobeto.rentACar.services.dtos.invoice.request.AddInvoiceRequest;
import com.tobeto.rentACar.services.dtos.invoice.request.DeleteInvoiceRequest;
import com.tobeto.rentACar.services.dtos.invoice.request.UpdateInvoiceRequest;
import com.tobeto.rentACar.services.dtos.invoice.response.GetAllInvoicesResponse;
import com.tobeto.rentACar.services.dtos.invoice.response.GetInvoiceByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/invoices")
@AllArgsConstructor
public class InvoicesController {
    private final InvoiceService invoiceService;

    @PostMapping
    public void add(@RequestBody @Valid AddInvoiceRequest request){
        invoiceService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateInvoiceRequest request){
        invoiceService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody @Valid DeleteInvoiceRequest request){
        invoiceService.delete(request);
    }

    @GetMapping
    public List<GetAllInvoicesResponse> getAll(){
        return invoiceService.getAll();
    }

    @GetMapping("{id}")
    public GetInvoiceByIdResponse getById(@PathVariable int id){
        return invoiceService.getById(id);
    }
}
