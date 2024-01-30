package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.services.JwtService;
import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.core.utilities.results.ErrorResult;
import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.rentACar.entities.concretes.Role;
import com.tobeto.rentACar.entities.concretes.User;
import com.tobeto.rentACar.services.abstracts.AuthCService;
import com.tobeto.rentACar.services.abstracts.RoleService;
import com.tobeto.rentACar.services.abstracts.UserService;
import com.tobeto.rentACar.services.constants.Messages;
import com.tobeto.rentACar.services.dtos.authentication.AuthCResult;
import com.tobeto.rentACar.services.dtos.authentication.LoginResponse;
import com.tobeto.rentACar.services.dtos.user.request.LoginUserRequest;
import com.tobeto.rentACar.services.dtos.user.request.RegisterUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class AuthCManager implements AuthCService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final MessageService messageService;

    @Override
    public Result register(RegisterUserRequest registerUserRequest) {
        Set<Role> authorities = registerUserRequest.getRoles().stream()
                .map(roleService::findByName)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        User user = User.builder()
                .email(registerUserRequest.getEmail())
                .authorities(authorities)
                .password(passwordEncoder.encode(registerUserRequest.getPassword()))
                .build();
        userService.add(user);

        return new SuccessResult(messageService.getMessage(Messages.User.userRegisterSuccess));
    }


    @Override
    public Result login(LoginUserRequest loginUserRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUserRequest.getEmail(),
                        loginUserRequest.getPassword()
                )
        );

        if (authentication.isAuthenticated()){
            String token = jwtService.generateToken(loginUserRequest.getEmail());
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(token);
            return new AuthCResult(true, messageService.getMessage(Messages.User.userLoginSuccess),loginResponse );
        }

        return new ErrorResult(messageService.getMessage(Messages.User.userCredentialsIncorrectMessage));
    }
}

