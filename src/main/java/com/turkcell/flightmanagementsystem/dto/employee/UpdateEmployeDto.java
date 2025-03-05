package com.turkcell.flightmanagementsystem.dto.employee;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class UpdateEmployeDto {

    private UUID id;

    @NotBlank(message = "İsim alanı boş bırakılmaz")
    private String firstName;

    @NotBlank(message = "Soyisim alanı boş bırakılmaz")
    private String lastName;
    @Email(message = "Eposta uygun formatta değil", regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    private String email;
    @NotBlank(message = "Telefon numarası  alanı boş bırakılmaz")
    private String phoneNumber;
    @NotBlank(message = "Departman alanı boş bırakılamaz")
    private String department;
    @NotBlank(message = "Pozisyon alanı boş bırakılamaz")
    private String position;
    private Double salary;
}
