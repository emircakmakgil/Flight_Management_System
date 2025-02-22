package com.turkcell.flightmanagementsystem.mapper;

import com.turkcell.flightmanagementsystem.dto.user.CreateUserDto;
import com.turkcell.flightmanagementsystem.entity.Role;
import com.turkcell.flightmanagementsystem.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/*
@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mapping(target = "password",expression = "java(mapUserPassword(createUserDto.getpassword()))")
    @Mapping(target = "roles",expression = "java(mapUserRoles(createUserDto.getroles()))")
    public abstract User createUserFromCreateUserDto(CreateUserDto createUserDto);

    protected String mapUserPassword(String password) {
        return passwordEncoder.encode(password);
    }
    protected List<Role>  mapUserRoles(Set<Role> roles) {
        return   roles.stream().toList();
    }
}
*/