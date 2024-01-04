package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.UserService;
import com.tobeto.rentACar.services.dtos.user.request.AddUserRequest;
import com.tobeto.rentACar.services.dtos.user.request.DeleteUserRequest;
import com.tobeto.rentACar.services.dtos.user.request.UpdateUserRequest;
import com.tobeto.rentACar.services.dtos.user.response.GetAllUsersResponse;
import com.tobeto.rentACar.services.dtos.user.response.GetUserByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UsersController {

    private final UserService userService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddUserRequest request){
        userService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateUserRequest request){
        userService.update(request);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody @Valid DeleteUserRequest request){
        userService.delete(request);
    }

    @GetMapping("/getAll")
    public List<GetAllUsersResponse> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetUserByIdResponse getById(@PathVariable int id){
        return  userService.getById(id);
    }
}
