package com.turkcell.flightmanagementsystem.dto.permission;

import com.turkcell.flightmanagementsystem.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreatePermissionDto {
    private String name;
    private String description;

}
