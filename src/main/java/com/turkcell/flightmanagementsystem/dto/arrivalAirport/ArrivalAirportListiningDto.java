package com.turkcell.flightmanagementsystem.dto.arrivalAirport;

import com.turkcell.flightmanagementsystem.entity.Flight;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class ArrivalAirportListiningDto {
    private String name;
    private String location;
    //private UUID flights;

    public ArrivalAirportListiningDto(String name, String location) {
        this.name = name;
        this.location = location;

    }
}
