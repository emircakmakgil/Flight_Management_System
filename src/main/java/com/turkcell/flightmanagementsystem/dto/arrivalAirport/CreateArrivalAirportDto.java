package com.turkcell.flightmanagementsystem.dto.arrivalAirport;

import com.turkcell.flightmanagementsystem.entity.Flight;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class CreateArrivalAirportDto {
    private String name;
    private String location;
   // private UUID flightIds;
}

