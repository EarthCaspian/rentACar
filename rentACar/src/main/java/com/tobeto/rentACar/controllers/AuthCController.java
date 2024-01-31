package com.tobeto.rentACar.controllers;


import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.services.abstracts.AuthCService;
import com.tobeto.rentACar.services.abstracts.UserService;
import com.tobeto.rentACar.services.dtos.user.request.LoginUserRequest;
import com.tobeto.rentACar.services.dtos.user.request.RegisterUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
@CrossOrigin
public class AuthCController {

    private final AuthCService authCService;

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegisterUserRequest registerUserRequest) {
        authCService.register(registerUserRequest);
    }

    @PostMapping("login")
    @ResponseStatus(HttpStatus.OK)
    public Result login(@RequestBody LoginUserRequest loginUserRequest) {
        return authCService.login(loginUserRequest);
    }

}
