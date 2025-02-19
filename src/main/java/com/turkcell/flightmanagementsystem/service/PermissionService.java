package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.dto.permission.CreatePermissionDto;
import com.turkcell.flightmanagementsystem.dto.permission.ListPermissionDto;
import com.turkcell.flightmanagementsystem.entity.Permission;

import java.util.List;
import java.util.UUID;

public interface PermissionService {
    void add(CreatePermissionDto createPermissionDto);
    List<ListPermissionDto> getAll();
    List<Permission> findByIds(List<UUID> ids);

}
