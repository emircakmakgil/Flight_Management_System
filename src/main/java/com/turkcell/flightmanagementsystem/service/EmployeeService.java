package com.turkcell.flightmanagementsystem.service;


import com.turkcell.flightmanagementsystem.dto.employee.CreateEmployeeDto;
import com.turkcell.flightmanagementsystem.dto.employee.DeleteEmployeeDto;
import com.turkcell.flightmanagementsystem.dto.employee.EmployeeListiningDto;
import com.turkcell.flightmanagementsystem.dto.employee.UpdateEmployeDto;
import com.turkcell.flightmanagementsystem.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {
    Optional<Employee> findById(UUID id);
    void add(CreateEmployeeDto createEmployeeDto);
    List<EmployeeListiningDto> getAll();
    Employee update(UpdateEmployeDto updateEmployeDto);
    void delete(DeleteEmployeeDto deleteEmployeeDto);
}
