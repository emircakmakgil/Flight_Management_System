package com.turkcell.flightmanagementsystem.dto.arrivalAirport;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateArrivalAirportDto {
    private UUID id;
    private String name;
    private String location;
}
