package com.turkcell.flightmanagementsystem.dto.permission;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListPermissionDto {
    private String name;
    private String description;
    public ListPermissionDto(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
