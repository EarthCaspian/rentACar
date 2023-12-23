package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsUserById(int userId);
    boolean existsUserByEmail(String email);
    boolean existsUserByName(String name);
    boolean existsUserBySurname(String surname);

}
