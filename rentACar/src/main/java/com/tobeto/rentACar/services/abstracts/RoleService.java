package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.concretes.Role;
import com.tobeto.rentACar.services.dtos.role.RoleDto;

import java.util.List;

public interface RoleService {

    RoleDto createRole(RoleDto roleDto);

    void deleteRole(Integer id);

    List<RoleDto> getAll();

    Role findByName(String name);

}
