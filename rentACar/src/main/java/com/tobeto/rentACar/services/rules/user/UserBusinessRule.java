package com.tobeto.rentACar.services.rules.user;

import com.tobeto.rentACar.core.utilities.exceptions.specificexceptions.EntityNotFoundException;
import com.tobeto.rentACar.core.utilities.exceptions.specificexceptions.ErrorHandlingService;
import com.tobeto.rentACar.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRule {

        private final UserRepository userRepository;

        public void existsUserById(int id) {
            if (!this.userRepository.existsById(id)) {
                throw new EntityNotFoundException(ErrorHandlingService.getUserNotFoundMessage(id));
            }
        }

        public void existsUserByEmail(String email) {
            if (!this.userRepository.existsByEmail(email)) {
                throw new RuntimeException("Email bulunamadı");
            }
        }


}
