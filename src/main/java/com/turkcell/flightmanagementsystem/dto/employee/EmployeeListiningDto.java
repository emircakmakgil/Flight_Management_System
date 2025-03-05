package com.turkcell.flightmanagementsystem.dto.employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeListiningDto {
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String department;
    private String position;
    private Double salary;

    public EmployeeListiningDto(String firstName, String lastName, String department, Double salary, String email) {
        this.name = firstName;
        this.surname = lastName;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }
}
