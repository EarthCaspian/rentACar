package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.services.JwtService;
import com.tobeto.rentACar.services.abstracts.AuthCService;
import com.tobeto.rentACar.services.dtos.user.request.LoginUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AuthCManager implements AuthCService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @Override
    public String login(LoginUserRequest loginUserRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUserRequest.getEmail(),
                        loginUserRequest.getPassword()
                )
        );

        if (authentication.isAuthenticated()){
            return jwtService.generateToken(loginUserRequest.getEmail());
        }

        throw new RuntimeException("Password or username is incorrect.");
    }
}

