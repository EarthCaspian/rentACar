package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.services.dtos.user.request.*;
import com.tobeto.rentACar.services.dtos.user.response.GetAllUsersResponse;
import com.tobeto.rentACar.services.dtos.user.response.GetUserByIdResponse;
import com.tobeto.rentACar.entities.concretes.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    Result add(AddUserRequest request);
    Result add(User user);
    Result update(UpdateUserRequest request);
    Result delete(DeleteUserRequest request);
    List<GetAllUsersResponse> getAll();
    GetUserByIdResponse getById(int id);

}
