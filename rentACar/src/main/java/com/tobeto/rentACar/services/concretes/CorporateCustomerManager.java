package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.concretes.CorporateCustomer;
import com.tobeto.rentACar.entities.concretes.User;
import com.tobeto.rentACar.repositories.CorporateCustomerRepository;
import com.tobeto.rentACar.services.abstracts.CorporateCustomerService;
import com.tobeto.rentACar.services.abstracts.UserService;
import com.tobeto.rentACar.services.dtos.corporateCustomer.request.AddCorporateCustomerRequest;
import com.tobeto.rentACar.services.dtos.corporateCustomer.request.DeleteCorporateCustomerRequest;
import com.tobeto.rentACar.services.dtos.corporateCustomer.request.UpdateCorporateCustomerRequest;
import com.tobeto.rentACar.services.dtos.corporateCustomer.response.GetAllCorporateCustomersResponse;
import com.tobeto.rentACar.services.dtos.corporateCustomer.response.GetCorporateCustomerByIdResponse;
import com.tobeto.rentACar.services.dtos.user.response.GetUserByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService {

	private final CorporateCustomerRepository corporateCustomerRepository;
	private final UserService userService;
	private final ModelMapperService modelMapperService;
	@Override
	public void add(AddCorporateCustomerRequest request) {
		if (corporateCustomerRepository.existsCorporateCustomerByTaxNo(request.getTaxNo()))
			throw  new RuntimeException("This tax number is already associated with an existing record.");

		CorporateCustomer corporateCustomer = modelMapperService.forRequest().map(request, CorporateCustomer.class);

		GetUserByIdResponse userResponse = userService.getById(request.getUserId());
		if (userResponse == null)
			throw new RuntimeException("User not found with id: " + request.getUserId());
		User user = this.modelMapperService.forRequest().map(userResponse, User.class);
		corporateCustomer.setUser(user);

		corporateCustomerRepository.save(corporateCustomer);
	}

	@Override
	public void update(UpdateCorporateCustomerRequest request) {

		CorporateCustomer corporateCustomer = modelMapperService.forRequest().map(request, CorporateCustomer.class);
		GetUserByIdResponse userResponse = userService.getById(request.getUserId());
		if (userResponse == null)
			throw new RuntimeException("User not found with id: " + request.getUserId());
		User user = this.modelMapperService.forRequest().map(userResponse, User.class);
		corporateCustomer.setUser(user);
		corporateCustomerRepository.save(corporateCustomer);
	}

	@Override
	public void delete(DeleteCorporateCustomerRequest request) {
		corporateCustomerRepository.findById(request.getId()).orElseThrow(() ->
				new NoSuchElementException("Corporate customer not found with ID: " + request.getId()));
		corporateCustomerRepository.deleteById(request.getId());
	}

	@Override
	public List<GetAllCorporateCustomersResponse> getAll() {
		List<CorporateCustomer> corporateCustomers = corporateCustomerRepository.findAll();
		List<GetAllCorporateCustomersResponse> corporateCustomerResponse = corporateCustomers
				.stream()
				.map((corporateCustomer) ->
						this.modelMapperService
								.forResponse()
								.map(corporateCustomer, GetAllCorporateCustomersResponse.class))
				.toList();
		return corporateCustomerResponse;
	}

	@Override
	public GetCorporateCustomerByIdResponse getById(int id) {
		CorporateCustomer corporateCustomer = corporateCustomerRepository.findById(id).orElseThrow( () ->
				new NoSuchElementException("Corporate customer not found with ID: " + id));
		return modelMapperService.forResponse().map(corporateCustomer, GetCorporateCustomerByIdResponse.class);
	}
}
