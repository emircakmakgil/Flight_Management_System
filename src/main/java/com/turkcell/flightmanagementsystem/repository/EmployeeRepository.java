package com.turkcell.flightmanagementsystem.repository;

import com.turkcell.flightmanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
