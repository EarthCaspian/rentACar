package com.tobeto.rentACar.services.rules;

import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.core.exceptions.types.BusinessException;
import com.tobeto.rentACar.repositories.UserRepository;
import com.tobeto.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRule {

        private final UserRepository userRepository;
        private final MessageService messageService;

        public void existsUserById(int id) {
            if (!userRepository.existsById(id)) {
                throw new BusinessException(messageService.getMessage(Messages.User.getUserNotFoundMessage));
            }
        }

        public void existsUserByEmail(String email) {
            if (userRepository.existsByEmail(email)) {
                throw new BusinessException(messageService.getMessage(Messages.User.getUserMailAlreadyExistsMessage));
            }
        }

}
