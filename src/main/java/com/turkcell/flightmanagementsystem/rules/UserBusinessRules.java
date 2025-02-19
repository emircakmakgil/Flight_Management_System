package com.turkcell.flightmanagementsystem.rules;

import com.turkcell.flightmanagementsystem.core.exception.type.BusinessException;
import com.turkcell.flightmanagementsystem.dto.user.ChangeUserPasswordDto;
import com.turkcell.flightmanagementsystem.dto.user.LoginUserDto;
import com.turkcell.flightmanagementsystem.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserBusinessRules {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserBusinessRules(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public void ValidateUser(Optional<User> user){
        user.ifPresent(u -> {
            throw new BusinessException("Kullanici zaten var");
        });
    }
    public void ValidateUser(Optional<User> user, ChangeUserPasswordDto changeUserPasswordDto){
        user.orElseThrow(() -> new BusinessException("Kullanıcı bulunamadı"));

        if(!bCryptPasswordEncoder.matches(changeUserPasswordDto.getOldPassword(), user.get().getPassword()))
            throw new BusinessException("Eski şifre hatalı");
    }
    public void ValidateUser(Optional<User> user, LoginUserDto loginUserDto){
        user.orElseThrow(() -> new BusinessException("Kullanici bulunamadı"));

        if(!bCryptPasswordEncoder.matches(loginUserDto.getPassword(), user.get().getPassword()))
            throw new BusinessException("Şifre hatalı");

    }

}
