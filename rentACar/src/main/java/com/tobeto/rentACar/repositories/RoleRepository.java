package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByName(String name);

}
