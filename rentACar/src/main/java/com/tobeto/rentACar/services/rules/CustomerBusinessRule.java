package com.tobeto.rentACar.services.rules;

import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.core.exceptions.types.BusinessException;
import com.tobeto.rentACar.entities.concretes.Customer;
import com.tobeto.rentACar.repositories.CustomerRepository;
import com.tobeto.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerBusinessRule {
    private final CustomerRepository customerRepository;
    private final MessageService messageService;

    public void checkCustomerAge(Customer customer) {
        if(customer.getAge(customer.getBirthdate())< 18){
            throw new BusinessException(messageService.getMessage(Messages.Customer.getCustomerAgeNotValidMessage));
        }
    }

    public void existsCustomerById(int id) {
        if (!customerRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Customer.getCustomerNotFoundMessage));
        }
    }

}
