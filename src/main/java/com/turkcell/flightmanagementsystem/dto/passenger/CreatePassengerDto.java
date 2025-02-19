package com.turkcell.flightmanagementsystem.dto.passenger;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class CreatePassengerDto {
    @NotBlank(message = "Name field cannot be left blank ")
    private String firstName;

    @NotBlank(message = "Surname field cannot be left blank")
    private String lastName;

    @Email(message = "Eposta uygun formatta değil", regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    @NotBlank(message = "Mail field cannot be left blank ")
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message="Şifre en az bir büyük harf, bir küçük harf ve bir rakam içermelidir.")
    @NotBlank(message = "Password field cannot be left blank")
    private String password;

    @NotBlank(message = "Phone number field cannot be left blank")
    private String phoneNumber;

    @Size(min = 0)
    @NotBlank(message = "Luggage field cannot be left blank")
    private int luggage;

    @NotBlank(message = "Passport field cannot be left blank")
    private String passport;
}
