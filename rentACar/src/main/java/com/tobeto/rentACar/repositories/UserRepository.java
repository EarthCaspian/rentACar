package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsById(int id);
    boolean existsByEmail(String email);
}
