package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.exceptions.types.NotFoundException;
import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.rentACar.entities.concretes.Customer;
import com.tobeto.rentACar.repositories.CustomerRepository;
import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.constants.Messages;
import com.tobeto.rentACar.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.request.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.request.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.response.GetAllCustomersResponse;
import com.tobeto.rentACar.services.dtos.customer.response.GetCustomerByIdResponse;
import com.tobeto.rentACar.services.rules.CustomerBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;
    private final CustomerBusinessRule customerBusinessRule;
    private MessageService messageService;
    @Override
    public Result add(AddCustomerRequest request) {

        //Converting uppercase characters to lowercase
        request.setFirstName(request.getFirstName().toLowerCase());
        request.setLastName(request.getLastName().toLowerCase());

        //Mapping
        Customer customer = modelMapperService.forRequest().map(request, Customer.class);

        //Business Rules
        customerBusinessRule.checkCustomerAge(customer);

        //Saving
        customerRepository.save(customer);
        return new SuccessResult(messageService.getMessage(Messages.Customer.customerAddSuccess));

    }

    @Override
    public Result update(UpdateCustomerRequest request) {

        //Converting uppercase characters to lowercase
        request.setFirstName(request.getFirstName().toLowerCase());
        request.setLastName(request.getLastName().toLowerCase());

        //Mapping
        Customer customer = modelMapperService.forRequest().map(request, Customer.class);

        //Business Rules
        customerBusinessRule.checkCustomerAge(customer);

        //Updating
        customerRepository.save(customer);

        return new SuccessResult(messageService.getMessage(Messages.Customer.customerUpdateSuccess));

    }

    @Override
    public Result delete(DeleteCustomerRequest request) {

        customerBusinessRule.existsCustomerById(request.getId());

        //Deleting
        customerRepository.deleteById(request.getId());

        return new SuccessResult(messageService.getMessage(Messages.Customer.customerDeleteSuccess));

    }

    @Override
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers
                .stream()
                .map((car) -> this.modelMapperService
                        .forResponse()
                        .map(car, GetAllCustomersResponse.class))
                .toList();
    }

    @Override
    public GetCustomerByIdResponse getById(int id) {

        Customer customer = customerRepository.findById(id).orElseThrow(() ->
                new NotFoundException(messageService.getMessage(Messages.Customer.getCustomerNotFoundMessage)));

        //Mapping the object to the response object
        return this.modelMapperService.forResponse()
                .map(customer, GetCustomerByIdResponse.class);

    }

}
