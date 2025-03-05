package com.turkcell.flightmanagementsystem.dto.departureAirport;

import com.turkcell.flightmanagementsystem.entity.Flight;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class DepartureAirportListiningDto {
    private String name;
    private String location;
   // private UUID flights;

    public DepartureAirportListiningDto(String name, String location) {
        this.name = name;
        this.location = location;

    }
}
