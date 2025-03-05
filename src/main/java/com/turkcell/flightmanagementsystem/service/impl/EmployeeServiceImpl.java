package com.turkcell.flightmanagementsystem.service.impl;

import com.turkcell.flightmanagementsystem.core.exception.jwt.JwtService;
import com.turkcell.flightmanagementsystem.dto.employee.CreateEmployeeDto;
import com.turkcell.flightmanagementsystem.dto.employee.DeleteEmployeeDto;
import com.turkcell.flightmanagementsystem.dto.employee.EmployeeListiningDto;
import com.turkcell.flightmanagementsystem.dto.employee.UpdateEmployeDto;
import com.turkcell.flightmanagementsystem.entity.Airline;
import com.turkcell.flightmanagementsystem.entity.Employee;
import com.turkcell.flightmanagementsystem.repository.EmployeeRepository;
import com.turkcell.flightmanagementsystem.service.EmployeeService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<Employee> findById(UUID id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void add(CreateEmployeeDto createEmployeeDto) {
        Employee employee = new Employee();
        employee.setFirstName(createEmployeeDto.getName());
        employee.setLastName(createEmployeeDto.getLastName());
        employee.setEmail(createEmployeeDto.getEmail());
        employee.setPhoneNumber(createEmployeeDto.getPhoneNumber());
        employee.setPassword(createEmployeeDto.getPassword());
        employee.setDepartment(createEmployeeDto.getDepartment());
        employee.setPosition(createEmployeeDto.getPosition());
        employee.setSalary(createEmployeeDto.getSalary());
        employeeRepository.save(employee);

    }

    @Override
    public List<EmployeeListiningDto> getAll() {
        List<EmployeeListiningDto> employeeListiningDtos = employeeRepository
                .findAll()
                .stream()
                .map((employee)-> new EmployeeListiningDto(employee.getFirstName(),employee.getLastName(),employee.getDepartment(),employee.getSalary(),employee.getEmail())).toList();
        return List.of();
    }

    @Override
    public Employee update(UpdateEmployeDto updateEmployeDto) {
        Employee employee = employeeRepository.findById(updateEmployeDto.getId()).orElseThrow(()-> new RuntimeException("Employee not found"));
        employee.setFirstName(updateEmployeDto.getFirstName());
        employee.setLastName(updateEmployeDto.getLastName());
        employee.setEmail(updateEmployeDto.getEmail());
        employee.setPhoneNumber(updateEmployeDto.getPhoneNumber());
        employee.setDepartment(updateEmployeDto.getDepartment());
        employee.setSalary(updateEmployeDto.getSalary());
        employee.setPosition(updateEmployeDto.getPosition());
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(DeleteEmployeeDto deleteEmployeeDto) {
        Employee employee=employeeRepository.findById(deleteEmployeeDto.getId()).orElseThrow(()-> new RuntimeException("Employee not found"));
        employeeRepository.delete(employee);

    }
}
