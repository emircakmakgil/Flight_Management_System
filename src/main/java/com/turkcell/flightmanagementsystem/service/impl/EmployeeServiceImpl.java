package com.turkcell.flightmanagementsystem.service.impl;

import com.turkcell.flightmanagementsystem.core.exception.jwt.JwtService;
import com.turkcell.flightmanagementsystem.dto.employee.*;
import com.turkcell.flightmanagementsystem.entity.Employee;
import com.turkcell.flightmanagementsystem.repository.EmployeeRepository;
import com.turkcell.flightmanagementsystem.rules.EmployeeBusinessRules;
import com.turkcell.flightmanagementsystem.service.EmployeeService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final EmployeeBusinessRules employeeBusinessRules;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, JwtService jwtService, BCryptPasswordEncoder bCryptPasswordEncoder, EmployeeBusinessRules employeeBusinessRules) {
        this.employeeRepository = employeeRepository;
        this.jwtService = jwtService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.employeeBusinessRules = employeeBusinessRules;
    }

    @Override
    public Optional<Employee> findById(UUID id) {
        return employeeRepository.findById(id);
    }

      @Override
      public void add(CreateEmployeeDto createEmployeeDto) {
      Employee employee = new Employee();
      employee.setFirstName(createEmployeeDto.getFirstName());
      employee.setLastName(createEmployeeDto.getLastName());
      employee.setEmail(createEmployeeDto.getEmail());
      employee.setPhoneNumber(createEmployeeDto.getPhoneNumber());
      employee.setPassword(bCryptPasswordEncoder.encode(createEmployeeDto.getPassword()));
      employee.setDepartment(createEmployeeDto.getDepartment());
      employee.setPosition(createEmployeeDto.getPosition());
      employee.setSalary(createEmployeeDto.getSalary());
      employee.setCreatedAt(new Date(System.currentTimeMillis()));
      employeeRepository.save(employee);
      }

    @Override
    public List<EmployeeListiningDto> getAll() {
        List<EmployeeListiningDto> employeeListiningDtos = employeeRepository
                .findAll()
                .stream()
                .map((employee) -> new EmployeeListiningDto(employee.getFirstName(), employee.getLastName(),
                        employee.getDepartment(), employee.getSalary(), employee.getEmail()))
                .toList();
        return employeeListiningDtos;
    }

    @Override
    public Employee update(UpdateEmployeeDto updateEmployeeDto) {
        Employee employee = employeeRepository.findById(updateEmployeeDto.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setFirstName(updateEmployeeDto.getFirstName());
        employee.setLastName(updateEmployeeDto.getLastName());
        employee.setEmail(updateEmployeeDto.getEmail());
        employee.setPhoneNumber(updateEmployeeDto.getPhoneNumber());
        employee.setDepartment(updateEmployeeDto.getDepartment());
        employee.setSalary(updateEmployeeDto.getSalary());
        employee.setPosition(updateEmployeeDto.getPosition());
        employee.setPassword(bCryptPasswordEncoder.encode(updateEmployeeDto.getPassword()));
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(DeleteEmployeeDto deleteEmployeeDto) {
        Employee employee = employeeRepository.findById(deleteEmployeeDto.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.delete(employee);
    }

    @Override
    public String login(LoginEmployeeDto loginEmployeeDto) {
        Optional<Employee> optionalEmployee=employeeRepository.findByEmail(loginEmployeeDto.getEmail());
        employeeBusinessRules.ValidateEmployee(optionalEmployee,loginEmployeeDto);
        return jwtService.generateToken(loginEmployeeDto.getEmail());
    }

    @Override
    public void updatePassword(ChangeEmployeePasswordDto changeEmployeePasswordDto) {
        Optional<Employee> optionalEmployee=employeeRepository.findByEmail(changeEmployeePasswordDto.getEmail());
        employeeBusinessRules.ValidateEmployee(optionalEmployee,changeEmployeePasswordDto);
        Employee employee=optionalEmployee.get();
        employee.setPassword(bCryptPasswordEncoder.encode(changeEmployeePasswordDto.getNewPassword()));
        employee.setUpdatedAt(new Date(System.currentTimeMillis()));
        employeeRepository.save(employee);
    }
}