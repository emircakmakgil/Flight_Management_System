package com.turkcell.flightmanagementsystem.dto.employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateEmployeeDto {
    @NotBlank(message = "İsim alanı boş bırakılamaz")
    private String firstName;
    @NotBlank(message = "Soyisim alanı boş bırakılmaz")
    private String lastName;
    @Email(message = "Eposta uygun formatta değil", regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    private String email;
    private String phoneNumber;
    @NotBlank(message = "Şifre alanı boş bırakılamaz")
    @Length(min = 6, message = "Şifre en az 6 karakter olmalıdır")
    private String password;
    private String department;
    private String position;
    private Double salary;
}
