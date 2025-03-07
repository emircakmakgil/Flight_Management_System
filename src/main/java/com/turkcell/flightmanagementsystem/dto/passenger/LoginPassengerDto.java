package com.turkcell.flightmanagementsystem.dto.passenger;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginPassengerDto {
    @NotBlank(message = "Email alanı dolu olmalıdır. ")
    private String email;
    @NotBlank(message = "Şifre alanı dolu olmalıdır.")
    private String password;
}
