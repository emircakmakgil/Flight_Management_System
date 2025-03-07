package com.turkcell.flightmanagementsystem.rules;

import com.turkcell.flightmanagementsystem.core.exception.type.BusinessException;
import com.turkcell.flightmanagementsystem.dto.employee.ChangeEmployeePasswordDto;
import com.turkcell.flightmanagementsystem.dto.employee.LoginEmployeeDto;
import com.turkcell.flightmanagementsystem.entity.Employee;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeBusinessRules {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public EmployeeBusinessRules(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public void ValidateEmployee(Optional<Employee> employee){
        employee.ifPresent(u -> {
            throw new BusinessException("Kullanici zaten var");
        });
    }
    public void ValidateEmployee(Optional<Employee> employee, ChangeEmployeePasswordDto changeEmployeePasswordDto){
        employee.orElseThrow(() -> new BusinessException("Kullanıcı bulunamadı"));

        if(!bCryptPasswordEncoder.matches(changeEmployeePasswordDto.getOldPassword(), employee.get().getPassword()))
            throw new BusinessException("Eski şifre hatalı");
    }
    public void ValidateEmployee(Optional<Employee> employee, LoginEmployeeDto loginEmployeeDto){
        employee.orElseThrow(() -> new BusinessException("Kullanici bulunamadı"));

        if(!bCryptPasswordEncoder.matches(loginEmployeeDto.getPassword(), employee.get().getPassword()))
            throw new BusinessException("Şifre hatalı");

    }

}
