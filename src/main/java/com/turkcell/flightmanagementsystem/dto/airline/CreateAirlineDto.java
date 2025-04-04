package com.turkcell.flightmanagementsystem.dto.airline;


import com.turkcell.flightmanagementsystem.entity.Flight;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateAirlineDto {

    @NotBlank
    private String name;

    @NotBlank(message = "Airline code is required")
    @Size(min = 2, max = 3, message = "Airline code must be 2 or 3 characters")
    private String code;

    @NotBlank
    private String country;


}
