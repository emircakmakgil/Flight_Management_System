package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.dto.user.CreateUserDto;
import com.turkcell.flightmanagementsystem.dto.user.ChangeUserPasswordDto;
import com.turkcell.flightmanagementsystem.dto.user.LoginUserDto;
import com.turkcell.flightmanagementsystem.dto.user.UserListiningDto;
import com.turkcell.flightmanagementsystem.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    void add(CreateUserDto createUserDto);
    void update(ChangeUserPasswordDto updateUserDto);
    List<UserListiningDto> getAll();
    String login(LoginUserDto loginUserDto);
    Optional<User> findById(UUID id);
}
