package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.concretes.Customer;
import com.tobeto.rentACar.repositories.CustomerRepository;
import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.request.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.request.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.response.GetAllCustomersResponse;
import com.tobeto.rentACar.services.dtos.customer.response.GetCustomerByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public void add(AddCustomerRequest request) {

        //Converting uppercase characters to lowercase
        request.setFirstName(request.getFirstName().toLowerCase());
        request.setLastName(request.getLastName().toLowerCase());

        //Mapping
        Customer customer = modelMapperService.forRequest().map(request, Customer.class);

        //Business Rules
        //Customer eligibility is restricted to individuals aged 18 years and above.
        if(customer.getAge(customer.getBirthdate())< 18){
            throw new RuntimeException("Customer eligibility is restricted to individuals aged 18 years and above!");
        }

        //Saving
        customerRepository.save(customer);

    }

    @Override
    public void update(UpdateCustomerRequest request) {

        //Converting uppercase characters to lowercase
        request.setFirstName(request.getFirstName().toLowerCase());
        request.setLastName(request.getLastName().toLowerCase());

        //Mapping
        Customer customer = modelMapperService.forRequest().map(request, Customer.class);

        //Business Rules
        //Customer eligibility is restricted to individuals aged 18 years and above.
        if(customer.getAge(customer.getBirthdate())< 18){
            throw new RuntimeException("Customer eligibility is restricted to individuals aged 18 years and above!");
        }

        //Updating
        customerRepository.save(customer);

    }

    @Override
    public void delete(DeleteCustomerRequest request) {

        //Checking whether the relevant customer exists or not
        customerRepository.findById(request.getId()).orElseThrow(() ->
                new NoSuchElementException("User not found with ID: " + request.getId()));

        //Deleting
        customerRepository.deleteById(request.getId());

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

        //Checking whether the relevant user exists or not
        Customer customer = customerRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("User not found with ID: " + id));

        //Mapping
        return modelMapperService.forResponse().map(customer, GetCustomerByIdResponse.class);

    }

}
