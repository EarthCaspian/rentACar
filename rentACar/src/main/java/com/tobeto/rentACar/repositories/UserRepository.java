package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.User;
import com.tobeto.rentACar.services.dtos.user.response.GetAllUsersResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsUserById(int userId);
    boolean existsUserByEmail(String email);
    boolean existsUserByName(String name);
    boolean existsUserBySurname(String surname);

    @Query("select new com.tobeto.rentACar.services.dtos.user.response.GetAllUsersResponse" +
            "(u.name, u.surname, u.email, u.birthdate) " +
            "from User u")
    List<GetAllUsersResponse> getAll();

}
