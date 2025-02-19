package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.dto.permission.CreatePermissionDto;
import com.turkcell.flightmanagementsystem.dto.permission.ListPermissionDto;
import com.turkcell.flightmanagementsystem.entity.Permission;
import com.turkcell.flightmanagementsystem.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public void add(CreatePermissionDto createPermissionDto) {
        Permission permission = new Permission();
        permission.setName(createPermissionDto.getName());
        permission.setDescription(createPermissionDto.getDescription());
        permissionRepository.save(permission);

    }

    @Override
    public List<ListPermissionDto> getAll() {
        List<ListPermissionDto> permissionDtos=permissionRepository
                .findAll()
                .stream()
                .map((permission)-> new ListPermissionDto(permission.getName(),permission.getDescription())).toList();
        return permissionDtos;
    }

    @Override
    public List<Permission> findByIds(List<UUID> ids) {
        return permissionRepository.findAllById(ids);
    }
}
