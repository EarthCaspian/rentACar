package com.tobeto.rentACar.services.rules;

import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.core.exceptions.types.BusinessException;
import com.tobeto.rentACar.repositories.InvoiceRepository;
import com.tobeto.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceBusinessRule {

    private final InvoiceRepository invoiceRepository;
    private final MessageService messageService;

    public void existsInvoiceById(int id) {
        if (!invoiceRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Invoice.getInvoiceNotFoundMessage));
        }
    }

}
