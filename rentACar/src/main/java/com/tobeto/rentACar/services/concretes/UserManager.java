package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.User;
import com.tobeto.rentACar.repositories.UserRepository;
import com.tobeto.rentACar.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;


    @Override
    public boolean existsUserById(int userId) {
        return userRepository.existsUserById(userId);
    }
}
