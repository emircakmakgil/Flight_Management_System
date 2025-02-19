package com.turkcell.flightmanagementsystem.dto.airline;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class AirlineListiningDto {

    private UUID id;
    private String code;
    private String name;
    private String country;


    public AirlineListiningDto(UUID id, String code, String name, String country) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.country = country;
    }
}
