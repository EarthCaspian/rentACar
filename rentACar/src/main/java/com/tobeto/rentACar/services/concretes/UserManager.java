package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.repositories.UserRepository;
import com.tobeto.rentACar.services.abstracts.UserService;
import com.tobeto.rentACar.services.dtos.user.request.AddUserRequest;
import com.tobeto.rentACar.services.dtos.user.request.DeleteUserRequest;
import com.tobeto.rentACar.services.dtos.user.request.UpdateUserRequest;
import com.tobeto.rentACar.services.dtos.user.response.GetAllUsersResponse;
import com.tobeto.rentACar.services.dtos.user.response.GetUserByIdResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
        //Converting uppercase characters to lowercase
        request.setName(request.getName().toLowerCase());
        request.setSurname(request.getSurname().toLowerCase());

        //Business Rules
        //An e-mail address can only be registered in the system once.
        if(userRepository.existsUserByEmail(request.getEmail())){
            throw new RuntimeException("A user account with this email address already exists!");
        }
        //A person can only be registered in the system once.
        if (userRepository.existsUserByName(request.getName()) &&
                userRepository.existsUserBySurname(request.getSurname())){
            throw new RuntimeException("A user account with this name already exists!");
        }


        //Mapping

        //Saving

    }

    @Override
    public void update(UpdateUserRequest request) {

    }

    @Override
    public void delete(DeleteUserRequest request) {

    }

    @Override
    public List<GetAllUsersResponse> getAll() {
        return null;
    }

    @Override
    public GetUserByIdResponse getById(int id) {
        return null;
    }
}
