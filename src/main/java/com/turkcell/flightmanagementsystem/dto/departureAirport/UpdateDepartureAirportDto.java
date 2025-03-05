package com.turkcell.flightmanagementsystem.dto.departureAirport;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateDepartureAirportDto {
    private UUID id;
    private String name;
    private String location;
}
