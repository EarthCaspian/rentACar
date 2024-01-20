package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.exceptions.types.NotFoundException;
import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.rentACar.entities.concretes.Invoice;
import com.tobeto.rentACar.repositories.InvoiceRepository;
import com.tobeto.rentACar.services.abstracts.InvoiceService;
import com.tobeto.rentACar.services.constants.Messages;
import com.tobeto.rentACar.services.dtos.invoice.request.AddInvoiceRequest;
import com.tobeto.rentACar.services.dtos.invoice.request.DeleteInvoiceRequest;
import com.tobeto.rentACar.services.dtos.invoice.request.UpdateInvoiceRequest;
import com.tobeto.rentACar.services.dtos.invoice.response.GetAllInvoicesResponse;
import com.tobeto.rentACar.services.dtos.invoice.response.GetInvoiceByIdResponse;
import com.tobeto.rentACar.services.rules.InvoiceBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ModelMapperService modelMapperService;
    private final InvoiceBusinessRule invoiceBusinessRule;
    private MessageService messageService;

    @Override
    public Result add(AddInvoiceRequest request) {

        //Mapping
        Invoice invoice = modelMapperService.forRequest().map(request, Invoice.class);

        //Saving
        invoiceRepository.save(invoice);

        return new SuccessResult(messageService.getMessage(Messages.Invoice.invoiceAddSuccess));

    }

    @Override
    public Result update(UpdateInvoiceRequest request) {

        //Mapping
        Invoice invoice = modelMapperService.forRequest().map(request, Invoice.class);

        //Updating
        invoiceRepository.save(invoice);

        return new SuccessResult(messageService.getMessage(Messages.Invoice.invoiceUpdateSuccess));

    }

    @Override
    public Result delete(DeleteInvoiceRequest request) {

        invoiceBusinessRule.existsInvoiceById(request.getId());

        //Deleting
        invoiceRepository.deleteById(request.getId());

        return new SuccessResult(messageService.getMessage(Messages.Invoice.invoiceDeleteSuccess));

    }

    @Override
    public List<GetAllInvoicesResponse> getAll() {

        List<Invoice> invoices = invoiceRepository.findAll();
        List<GetAllInvoicesResponse> invoicesResponses = invoices.stream().map(invoice -> this.modelMapperService.forResponse().map(invoice, GetAllInvoicesResponse.class)).toList();
        return invoicesResponses;
    }

    @Override
    public GetInvoiceByIdResponse getById(int id) {

        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() ->
                new NotFoundException(messageService.getMessage(Messages.Invoice.getInvoiceNotFoundMessage)));

        //Mapping the object to the response object
        return this.modelMapperService.forResponse()
                .map(invoice, GetInvoiceByIdResponse.class);
    }
}
