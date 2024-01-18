package com.tobeto.rentACar.services.rules;

import com.tobeto.rentACar.core.exceptions.internationalization.MessageService;
import com.tobeto.rentACar.core.exceptions.types.BusinessException;
import com.tobeto.rentACar.repositories.CorporateCustomerRepository;
import com.tobeto.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CorporateCustomerBusinessRule {

    private final CorporateCustomerRepository corporateCustomerRepository;
    private final MessageService messageService;

    public void existsCorporateCustomerByTaxNo (String taxNo){
        if (corporateCustomerRepository.existsCorporateCustomerByTaxNo(taxNo))
            throw new BusinessException(messageService.getMessage(Messages.Brand.getBrandNameAlreadyExistsMessage));
    }
    public void existsCorporateCustomerById(int id) {
        if (!corporateCustomerRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Brand.getBrandNotFoundMessage));
        }
    }
}
