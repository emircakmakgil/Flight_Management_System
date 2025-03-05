package com.turkcell.flightmanagementsystem.service.impl;

import com.turkcell.flightmanagementsystem.dto.role.CreateRoleDto;
import com.turkcell.flightmanagementsystem.dto.role.ListRoleDto;
import com.turkcell.flightmanagementsystem.dto.role.UpdateRoleDto;
import com.turkcell.flightmanagementsystem.entity.Permission;
import com.turkcell.flightmanagementsystem.entity.Role;
import com.turkcell.flightmanagementsystem.repository.RoleRepository;
import com.turkcell.flightmanagementsystem.service.PermissionService;
import com.turkcell.flightmanagementsystem.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final PermissionService permissionService;

    public RoleServiceImpl(RoleRepository roleRepository, PermissionService permissionService) {
        this.roleRepository = roleRepository;
        this.permissionService = permissionService;
    }

    @Override
    public void add(CreateRoleDto createRoleDto) {
        List<Permission> permissions = permissionService.findByIds(createRoleDto.getPermissionIds());
        Role role = new Role();
        role.setName(createRoleDto.getName());
        role.setPermissions((Set<Permission>) permissions);
        roleRepository.save(role);


    }

    @Override
    public void update(UpdateRoleDto updateRoleDto) {
        List<Permission> permissions = permissionService.findByIds(updateRoleDto.getPermissionIds());
        Role role =roleRepository.findById(updateRoleDto.getId()).orElseThrow(()->new RuntimeException("You don't have permission"));
        role.setName(updateRoleDto.getName());
        role.setPermissions((Set<Permission>) permissions);
        roleRepository.save(role);



    }

    @Override
    public List<ListRoleDto> getAll() {
        List<ListRoleDto> roleDtos = roleRepository
                .findAll()
                .stream()
                .map((role -> new ListRoleDto(role.getName(),role.getPermissions()))).toList();
        return roleDtos;
    }

    @Override
    public List<Role> getRolesByNames(List<String> roleNames) {

        return roleRepository.findAllByNameIn(roleNames);
    }
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }





}
