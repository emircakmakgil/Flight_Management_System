package com.turkcell.flightmanagementsystem.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserListiningDto {
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;

    public UserListiningDto(String firstName, String lastName, String email, String phoneNumber) {
        this.name = firstName;
        this.surname = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }
}
