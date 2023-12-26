package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.user.request.AddUserRequest;
import com.tobeto.rentACar.services.dtos.user.request.DeleteUserRequest;
import com.tobeto.rentACar.services.dtos.user.request.UpdateUserRequest;
import com.tobeto.rentACar.services.dtos.user.response.GetAllUsersResponse;
import com.tobeto.rentACar.services.dtos.user.response.GetUserByIdResponse;

import java.util.List;

public interface UserService {

    boolean existsUserById(int userId);

    void add(AddUserRequest request);
    void update(UpdateUserRequest request);
    void delete(DeleteUserRequest request);
    List<GetAllUsersResponse> getAll();
    GetUserByIdResponse getById(int id);
}
