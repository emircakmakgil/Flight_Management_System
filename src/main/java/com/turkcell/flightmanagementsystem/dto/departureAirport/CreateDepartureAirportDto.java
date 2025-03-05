package com.turkcell.flightmanagementsystem.dto.departureAirport;

import com.turkcell.flightmanagementsystem.entity.Flight;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class CreateDepartureAirportDto {
    private String name;
    private String location;
    //private UUID flightsId;

}
