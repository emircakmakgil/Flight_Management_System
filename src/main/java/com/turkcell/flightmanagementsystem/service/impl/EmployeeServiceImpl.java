package com.turkcell.flightmanagementsystem.service.impl;

import com.turkcell.flightmanagementsystem.dto.employee.CreateEmployeeDto;
import com.turkcell.flightmanagementsystem.dto.employee.DeleteEmployeeDto;
import com.turkcell.flightmanagementsystem.dto.employee.EmployeeListiningDto;
import com.turkcell.flightmanagementsystem.dto.employee.UpdateEmployeeDto;
import com.turkcell.flightmanagementsystem.entity.Employee;
import com.turkcell.flightmanagementsystem.mapper.EmployeeMapper;
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

    private final EmployeeMapper employeeMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.employeeRepository = employeeRepository;

        this.employeeMapper = employeeMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Optional<Employee> findById(UUID id) {
        return employeeRepository.findById(id);
    }

    /*
     * @Override
     * public void add(CreateEmployeeDto createEmployeeDto) {
     * Employee employee = new Employee();
     * employee.setFirstName(createEmployeeDto.getName());
     * employee.setLastName(createEmployeeDto.getLastName());
     * employee.setEmail(createEmployeeDto.getEmail());
     * employee.setPhoneNumber(createEmployeeDto.getPhoneNumber());
     * employee.setPassword(bCryptPasswordEncoder.encode(createEmployeeDto.
     * getPassword()));
     * employee.setDepartment(createEmployeeDto.getDepartment());
     * employee.setPosition(createEmployeeDto.getPosition());
     * employee.setSalary(createEmployeeDto.getSalary());
     * employeeRepository.save(employee);
     * 
     * }
     */
    @Override
    public void add(CreateEmployeeDto createEmployeeDto) {
        Employee employee = employeeMapper.toEntity(createEmployeeDto);
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
}
