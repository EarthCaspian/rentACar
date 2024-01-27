package com.tobeto.rentACar.controllers;


import com.tobeto.rentACar.services.abstracts.RoleService;
import com.tobeto.rentACar.services.dtos.role.RoleDto;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/roles")
@CrossOrigin
@Data
public class RolesController {
    private final RoleService roleService;

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/add")
    public RoleDto createRole(@RequestBody RoleDto roleDto) {
        return roleService.createRole(roleDto);
    }

    @DeleteMapping("/delete")
    public void deleteRole(Integer id) {
        roleService.deleteRole(id);
    }
}
