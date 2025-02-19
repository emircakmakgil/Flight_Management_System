package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.dto.role.CreateRoleDto;
import com.turkcell.flightmanagementsystem.dto.role.ListRoleDto;
import com.turkcell.flightmanagementsystem.dto.role.UpdateRoleDto;
import com.turkcell.flightmanagementsystem.entity.Role;

import java.util.List;

public interface RoleService {
    void add(CreateRoleDto createRoleDto);
    void update(UpdateRoleDto updateRoleDto);
    List<ListRoleDto> getAll();
    List<Role> getRolesByNames(List<String> roleNames);

}
