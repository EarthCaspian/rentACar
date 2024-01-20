package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.exceptions.types.NotFoundException;
import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.core.utilities.results.SuccessDataResult;
import com.tobeto.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.rentACar.entities.concretes.User;
import com.tobeto.rentACar.repositories.UserRepository;
import com.tobeto.rentACar.services.abstracts.UserService;
import com.tobeto.rentACar.services.constants.Messages;
import com.tobeto.rentACar.services.dtos.user.request.AddUserRequest;
import com.tobeto.rentACar.services.dtos.user.request.DeleteUserRequest;
import com.tobeto.rentACar.services.dtos.user.request.UpdateUserRequest;
import com.tobeto.rentACar.services.dtos.user.response.GetAllUsersResponse;
import com.tobeto.rentACar.services.dtos.user.response.GetUserByIdResponse;
import com.tobeto.rentACar.services.rules.UserBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final UserBusinessRule userBusinessRule;
    private MessageService messageService;

    @Override
    public Result add(AddUserRequest request) {

        userBusinessRule.existsUserByEmail(request.getEmail());

        User user = modelMapperService.forRequest().map(request, User.class);

        userRepository.save(user);

        return new SuccessResult(messageService.getMessage(Messages.User.userAddSuccess));

    }

    @Override
    public Result update(UpdateUserRequest request) {

        userBusinessRule.existsUserByEmail(request.getEmail());
        userBusinessRule.existsUserById(request.getId());

        User user = modelMapperService.forRequest().map(request, User.class);

        userRepository.save(user);

        return new SuccessDataResult(messageService.getMessage(Messages.User.userUpdateSuccess));
    }

    @Override
    public Result delete(DeleteUserRequest request) {

        userBusinessRule.existsUserById(request.getId());

        userRepository.deleteById(request.getId());

        return new SuccessResult(messageService.getMessage(Messages.User.userDeleteSuccess));
    }

    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(user -> this.modelMapperService
                        .forResponse()
                        .map(user, GetAllUsersResponse.class))
                .toList();
    }

    @Override
    public GetUserByIdResponse getById(int id) {

        User user = userRepository.findById(id).orElseThrow(() ->
                new NotFoundException(messageService.getMessage(Messages.User.getUserNotFoundMessage)));

        //Mapping the object to the response object
        return this.modelMapperService.forResponse()
                .map(user, GetUserByIdResponse.class);

    }
}
