package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.services.dtos.user.request.*;
import com.tobeto.rentACar.services.dtos.user.response.GetAllUsersResponse;
import com.tobeto.rentACar.services.dtos.user.response.GetUserByIdResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    Result add(AddUserRequest request);
    Result update(UpdateUserRequest request);
    Result delete(DeleteUserRequest request);
    List<GetAllUsersResponse> getAll();
    GetUserByIdResponse getById(int id);
    Result register(RegisterUserRequest request);
    Result login(LoginUserRequest request);
}
