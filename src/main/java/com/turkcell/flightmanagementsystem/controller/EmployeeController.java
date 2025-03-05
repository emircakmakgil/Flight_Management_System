package com.turkcell.flightmanagementsystem.controller;

import com.turkcell.flightmanagementsystem.dto.employee.CreateEmployeeDto;
import com.turkcell.flightmanagementsystem.dto.employee.DeleteEmployeeDto;
import com.turkcell.flightmanagementsystem.dto.employee.EmployeeListiningDto;
import com.turkcell.flightmanagementsystem.dto.employee.UpdateEmployeDto;
import com.turkcell.flightmanagementsystem.service.EmployeeService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<EmployeeListiningDto> getAllEmployees() {
        return this.employeeService.getAll();
    }
    @PostMapping
    public void add(@RequestBody CreateEmployeeDto employeeDto) {
        this.employeeService.add(employeeDto);
    }
    @PutMapping
    public void update(@RequestBody UpdateEmployeDto employeeDto) {
        this.employeeService.update(employeeDto);
    }
    @DeleteMapping
    public void delete(@RequestBody DeleteEmployeeDto employeeDto) {
        this.employeeService.delete(employeeDto);
    }
}
