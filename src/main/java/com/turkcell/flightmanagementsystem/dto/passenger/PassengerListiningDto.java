package com.turkcell.flightmanagementsystem.dto.passenger;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassengerListiningDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private int luggage;
    private String passport;

    public PassengerListiningDto(String firstName, String lastName, String email, String phoneNumber, int luggage, String passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.luggage = luggage;
        this.passport = passport;
    }
}
