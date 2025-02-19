package com.turkcell.flightmanagementsystem.controller;

import com.turkcell.flightmanagementsystem.dto.user.ChangeUserPasswordDto;
import com.turkcell.flightmanagementsystem.dto.user.CreateUserDto;
import com.turkcell.flightmanagementsystem.dto.user.LoginUserDto;
import com.turkcell.flightmanagementsystem.dto.user.UserListiningDto;
import com.turkcell.flightmanagementsystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/all")
    public List<UserListiningDto> getAll() {
        return userService.getAll();
    }
    @PostMapping
    public void add(@RequestBody CreateUserDto createUserDto) {
        userService.add(createUserDto);

    }
    @PutMapping("/change-password")
    public void update(@RequestBody ChangeUserPasswordDto changeUserPasswordDto) {
        userService.update(changeUserPasswordDto);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginUserDto loginUserDto) {
        return userService.login(loginUserDto);
    }
}
