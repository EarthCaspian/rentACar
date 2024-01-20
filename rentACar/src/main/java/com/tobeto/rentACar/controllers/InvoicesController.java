package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.core.utilities.results.Result;
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
@CrossOrigin
public class InvoicesController {
    private final InvoiceService invoiceService;

    @PostMapping("/add")
    public Result add(@RequestBody @Valid AddInvoiceRequest request){
        return invoiceService.add(request);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateInvoiceRequest request){
        return invoiceService.update(request);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteInvoiceRequest request){
        return invoiceService.delete(request);
    }

    @GetMapping("/getAll")
    public List<GetAllInvoicesResponse> getAll(){
        return invoiceService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetInvoiceByIdResponse getById(@PathVariable int id){
        return invoiceService.getById(id);
    }
}
