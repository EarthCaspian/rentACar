package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.services.abstracts.AuthCService;
import com.tobeto.rentACar.services.abstracts.UserService;
import com.tobeto.rentACar.services.dtos.user.request.*;
import com.tobeto.rentACar.services.dtos.user.response.GetAllUsersResponse;
import com.tobeto.rentACar.services.dtos.user.response.GetUserByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
@CrossOrigin
public class UsersController {

    private final UserService userService;

    @PostMapping("/add")
    public Result add(@RequestBody @Valid AddUserRequest request){
        return userService.add(request);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateUserRequest request){
        return userService.update(request);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteUserRequest request){
        return userService.delete(request);
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
