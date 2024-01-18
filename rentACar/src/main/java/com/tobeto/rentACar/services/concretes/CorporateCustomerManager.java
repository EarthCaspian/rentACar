package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.exceptions.internationalization.MessageService;
import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.rentACar.entities.concretes.CorporateCustomer;
import com.tobeto.rentACar.entities.concretes.User;
import com.tobeto.rentACar.repositories.CorporateCustomerRepository;
import com.tobeto.rentACar.services.abstracts.CorporateCustomerService;
import com.tobeto.rentACar.services.abstracts.UserService;
import com.tobeto.rentACar.services.constants.Messages;
import com.tobeto.rentACar.services.dtos.color.response.GetColorByIdResponse;
import com.tobeto.rentACar.services.dtos.corporateCustomer.request.AddCorporateCustomerRequest;
import com.tobeto.rentACar.services.dtos.corporateCustomer.request.DeleteCorporateCustomerRequest;
import com.tobeto.rentACar.services.dtos.corporateCustomer.request.UpdateCorporateCustomerRequest;
import com.tobeto.rentACar.services.dtos.corporateCustomer.response.GetAllCorporateCustomersResponse;
import com.tobeto.rentACar.services.dtos.corporateCustomer.response.GetCorporateCustomerByIdResponse;
import com.tobeto.rentACar.services.dtos.user.response.GetUserByIdResponse;
import com.tobeto.rentACar.services.rules.CorporateCustomerBusinessRule;
import com.tobeto.rentACar.services.rules.UserBusinessRule;
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
	private final CorporateCustomerBusinessRule corporateCustomerBusinessRule;
	private final UserBusinessRule userBusinessRule;
	private MessageService messageService;

	@Override
	public Result add(AddCorporateCustomerRequest request) {

		corporateCustomerBusinessRule.existsCorporateCustomerByTaxNo(request.getTaxNo());
		userBusinessRule.existsUserById(request.getUserId());

		CorporateCustomer corporateCustomer = modelMapperService.forRequest().map(request, CorporateCustomer.class);
		corporateCustomer.setId(null);

		GetUserByIdResponse userResponse = userService.getById(request.getUserId());

		User user = this.modelMapperService.forRequest().map(userResponse, User.class);
		corporateCustomer.setUser(user);

		corporateCustomerRepository.save(corporateCustomer);

		return new SuccessResult(messageService.getMessage(Messages.CorporateCustomer.corporateCustomerAddSuccess));

	}

	@Override
	public Result update(UpdateCorporateCustomerRequest request) {

		userBusinessRule.existsUserById(request.getUserId());

		CorporateCustomer corporateCustomer = modelMapperService.forRequest().map(request, CorporateCustomer.class);

		GetUserByIdResponse userResponse = userService.getById(request.getUserId());

		User user = this.modelMapperService.forRequest().map(userResponse, User.class);
		corporateCustomer.setUser(user);
		corporateCustomerRepository.save(corporateCustomer);

		return new SuccessResult(messageService.getMessage(Messages.CorporateCustomer.corporateCustomerUpdateSuccess));


	}

	@Override
	public Result delete(DeleteCorporateCustomerRequest request) {

		corporateCustomerBusinessRule.existsCorporateCustomerById(request.getId());

		corporateCustomerRepository.deleteById(request.getId());

		return new SuccessResult(messageService.getMessage(Messages.CorporateCustomer.corporateCustomerDeleteSuccess));

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

		corporateCustomerBusinessRule.existsCorporateCustomerById(id);

		GetCorporateCustomerByIdResponse response = modelMapperService.forResponse().map(corporateCustomerRepository.findById(id), GetCorporateCustomerByIdResponse.class);
		return response;
	}
}
