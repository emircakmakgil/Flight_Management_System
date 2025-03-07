package com.turkcell.flightmanagementsystem.service;


import com.turkcell.flightmanagementsystem.dto.employee.*;
import com.turkcell.flightmanagementsystem.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {
    Optional<Employee> findById(UUID id);
    void add(CreateEmployeeDto createEmployeeDto);
    List<EmployeeListiningDto> getAll();
    Employee update(UpdateEmployeeDto updateEmployeeDto);
    void delete(DeleteEmployeeDto deleteEmployeeDto);
    String login(LoginEmployeeDto loginEmployeeDto);
    void updatePassword(ChangeEmployeePasswordDto changeEmployeePasswordDto);


}
