package com.turkcell.flightmanagementsystem.dto.airline;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateAirlineDto {
    private UUID id;
    private String code;
    private String name;
    private String country;
}
