package com.turkcell.flightmanagementsystem.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Setter

public class CreateUserDto {

    @NotBlank(message = "İsim alanı boş bırakılamaz")
    private String name;
    @NotBlank(message = "Soyisim alanı boş bırakılmaz")
    private String lastName;
    @Email(message = "Eposta uygun formatta değil", regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    private String email;
    private String phoneNumber;

    @Length(min=8)
    @NotBlank
    private String password;
    private List<String> roles;
}
