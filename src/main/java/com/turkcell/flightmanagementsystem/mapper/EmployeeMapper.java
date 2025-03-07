package com.turkcell.flightmanagementsystem.mapper;

import com.turkcell.flightmanagementsystem.dto.employee.CreateEmployeeDto;
import com.turkcell.flightmanagementsystem.dto.employee.EmployeeListiningDto;
import com.turkcell.flightmanagementsystem.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    // CreateEmployeeDto -> Employee
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "password", expression = "java(encodePassword(createEmployeeDto.getPassword()))")
    public abstract Employee toEntity(CreateEmployeeDto createEmployeeDto);

    // Employee -> EmployeeListiningDto
    public abstract EmployeeListiningDto toDto(Employee employee);

    // List<Employee> -> List<EmployeeListiningDto>
    public abstract List<EmployeeListiningDto> toDtoList(List<Employee> employees);

    /*
    // UpdateEmployeDto -> Employee (güncelleme için)
    @Mapping(target = "password", expression = "java(encodePassword(updateEmployeDto.getPassword()))")
    public abstract void updateEmployeeFromDto(UpdateEmployeDto updateEmployeDto, @MappingTarget Employee employee);
   */
    // Şifre şifreleme yardımcı metodu
    protected String encodePassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        return passwordEncoder.encode(password);
    }
}