package com.turkcell.flightmanagementsystem.dto.role;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class UpdateRoleDto {
    private UUID id;
    private String name;
    private List<UUID> permissionIds;
}
