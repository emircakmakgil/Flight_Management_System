package com.turkcell.flightmanagementsystem.rules;

import com.turkcell.flightmanagementsystem.core.exception.type.BusinessException;
import com.turkcell.flightmanagementsystem.dto.employee.ChangeEmployeePasswordDto;
import com.turkcell.flightmanagementsystem.dto.employee.LoginEmployeeDto;
import com.turkcell.flightmanagementsystem.dto.passenger.ChangePassengerPasswordDto;
import com.turkcell.flightmanagementsystem.dto.passenger.LoginPassengerDto;
import com.turkcell.flightmanagementsystem.entity.Employee;
import com.turkcell.flightmanagementsystem.entity.Passenger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PassengerBusinessRules {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public PassengerBusinessRules(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void ValidatePassenger(Optional<Passenger> passenger){
        passenger.ifPresent(u -> {
            throw new BusinessException("Kullanici zaten var");
        });
    }
    public void ValidatePassenger(Optional<Passenger> passenger, ChangePassengerPasswordDto changePassengerPasswordDto){
        passenger.orElseThrow(() -> new BusinessException("Kullanıcı bulunamadı"));

        if(!bCryptPasswordEncoder.matches(changePassengerPasswordDto.getOldPassword(), passenger.get().getPassword()))
            throw new BusinessException("Eski şifre hatalı");
    }
    public void ValidatePassenger(Optional<Passenger> passenger, LoginPassengerDto loginPassengerDto){
        passenger.orElseThrow(() -> new BusinessException("Kullanici bulunamadı"));

        if(!bCryptPasswordEncoder.matches(loginPassengerDto.getPassword(), passenger.get().getPassword()))
            throw new BusinessException("Şifre hatalı");

    }
}
