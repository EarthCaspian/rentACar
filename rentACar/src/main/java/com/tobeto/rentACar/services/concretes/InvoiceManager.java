package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.concretes.Invoice;
import com.tobeto.rentACar.repositories.InvoiceRepository;
import com.tobeto.rentACar.services.abstracts.InvoiceService;
import com.tobeto.rentACar.services.dtos.invoice.request.AddInvoiceRequest;
import com.tobeto.rentACar.services.dtos.invoice.request.DeleteInvoiceRequest;
import com.tobeto.rentACar.services.dtos.invoice.request.UpdateInvoiceRequest;
import com.tobeto.rentACar.services.dtos.invoice.response.GetAllInvoicesResponse;
import com.tobeto.rentACar.services.dtos.invoice.response.GetInvoiceByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(AddInvoiceRequest request) {

        //Mapping
        Invoice invoice = modelMapperService.forRequest().map(request, Invoice.class);

        //Saving
        invoiceRepository.save(invoice);
    }

    @Override
    public void update(UpdateInvoiceRequest request) {

        //Mapping
        Invoice invoice = modelMapperService.forRequest().map(request, Invoice.class);

        //Updating
        invoiceRepository.save(invoice);
    }

    @Override
    public void delete(DeleteInvoiceRequest request) {

        //Checking whether the relevant invoice exists or not
        invoiceRepository.findById(request.getId()).orElseThrow(() ->
                new NoSuchElementException("Invoice not found with ID: " + request.getId()));

        //Deleting
        invoiceRepository.deleteById(request.getId());
    }

    @Override
    public List<GetAllInvoicesResponse> getAll() {

        List<Invoice> invoices = invoiceRepository.findAll();
        List<GetAllInvoicesResponse> invoicesResponses = invoices.stream().map(invoice -> this.modelMapperService.forResponse().map(invoice, GetAllInvoicesResponse.class)).toList();
        return invoicesResponses;
    }

    @Override
    public GetInvoiceByIdResponse getById(int id) {

        //Checking whether the relevant invoice exists or not
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Invoice not found with ID: " + id));

        //Mapping
        return modelMapperService.forResponse().map(invoice, GetInvoiceByIdResponse.class);
    }
}
