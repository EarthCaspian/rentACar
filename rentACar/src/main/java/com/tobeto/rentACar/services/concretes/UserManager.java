package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.concretes.User;
import com.tobeto.rentACar.repositories.UserRepository;
import com.tobeto.rentACar.services.abstracts.UserService;
import com.tobeto.rentACar.services.dtos.user.request.AddUserRequest;
import com.tobeto.rentACar.services.dtos.user.request.DeleteUserRequest;
import com.tobeto.rentACar.services.dtos.user.request.UpdateUserRequest;
import com.tobeto.rentACar.services.dtos.user.response.GetAllUsersResponse;
import com.tobeto.rentACar.services.dtos.user.response.GetUserByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;


    @Override
    public boolean existsUserById(int userId) {
        return userRepository.existsUserById(userId);
    }

    @Override
    public void add(AddUserRequest request) {

        //Business Rules
        //An e-mail address can only be registered in the system once.
        if(userRepository.existsUserByEmail(request.getEmail())){
            throw new RuntimeException("A user account with this email address already exists!");
        }

        //Mapping
        User user = modelMapperService.forRequest().map(request, User.class);

        //Saving
        userRepository.save(user);

    }

    @Override
    public void update(UpdateUserRequest request) {

        //Business Rules
        //An e-mail address can only be registered in the system once.
        if(userRepository.existsUserByEmail(request.getEmail())){
            throw new RuntimeException("A user account with this email address already exists!");
        }

        //Mapping
        User user = modelMapperService.forRequest().map(request, User.class);

        //Saving
        userRepository.save(user);

    }

    @Override
    public void delete(DeleteUserRequest request) {
        //Checking whether the relevant user exists or not
        userRepository.findById(request.getId()).orElseThrow(() ->
                new NoSuchElementException("User not found with ID: " + request.getId()));

        //Deleting
        userRepository.deleteById(request.getId());

    }

    @Override
    public List<GetAllUsersResponse> getAll() {
        return userRepository.getAll();
    }

    @Override
    public GetUserByIdResponse getById(int id) {
        //Checking whether the relevant user exists or not
        User user = userRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("User not found with ID: " + id));

        //Mapping
        return modelMapperService.forResponse().map(user, GetUserByIdResponse.class);
    }
}
