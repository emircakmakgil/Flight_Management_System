package com.turkcell.flightmanagementsystem.dto.role;

import com.turkcell.flightmanagementsystem.entity.Permission;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class ListRoleDto {
    private String name;
    private Set<Permission> permissions;
    public ListRoleDto(String name, Set<Permission> permissions) {
        this.name = name;
        this.permissions = permissions;
    }
}
