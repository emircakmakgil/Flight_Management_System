package com.turkcell.flightmanagementsystem.controller;

import com.turkcell.flightmanagementsystem.dto.employee.*;
import com.turkcell.flightmanagementsystem.dto.user.ChangeUserPasswordDto;
import com.turkcell.flightmanagementsystem.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController
{
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<EmployeeListiningDto> getAll(){
        return employeeService.getAll();
    }
    @PostMapping
    public void add(@RequestBody CreateEmployeeDto createEmployeeDto) {
        this.employeeService.add(createEmployeeDto);
    }
    @PutMapping
    public void update(@RequestBody UpdateEmployeeDto updateEmployeeDto) {
        this.employeeService.update(updateEmployeeDto);
    }
    @DeleteMapping
    public void delete(@RequestBody DeleteEmployeeDto deleteEmployeeDto) {
        this.employeeService.delete(deleteEmployeeDto);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginEmployeeDto loginEmployeeDto) {
        return employeeService.login(loginEmployeeDto);
    }
    @PutMapping("/change-password")
    public void update(@RequestBody ChangeEmployeePasswordDto changeEmployeePasswordDto) {
        employeeService.updatePassword(changeEmployeePasswordDto);
    }
}
