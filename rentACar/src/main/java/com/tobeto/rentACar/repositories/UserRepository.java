package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.User;
import com.tobeto.rentACar.services.dtos.user.response.GetAllUsersResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsById(int id);
    boolean existsByEmail(String email);
}
