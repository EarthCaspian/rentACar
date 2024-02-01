package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.concretes.Role;
import com.tobeto.rentACar.repositories.RoleRepository;
import com.tobeto.rentACar.services.abstracts.RoleService;
import com.tobeto.rentACar.services.dtos.role.RoleDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class RoleManager implements RoleService {

    private final ModelMapperService modelMapperService;
    private final RoleRepository roleRepository;


    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role role = modelMapperService.forRequest().map(roleDto, Role.class);
        Role savedRole = roleRepository.save(role);
        return modelMapperService.forResponse().map(savedRole, RoleDto.class);
    }

    @Override
    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<RoleDto> getAll() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(role -> this.modelMapperService.forResponse().map(role, RoleDto.class)).toList();
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
