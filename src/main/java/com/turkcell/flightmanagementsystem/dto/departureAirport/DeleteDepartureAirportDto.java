package com.turkcell.flightmanagementsystem.dto.departureAirport;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class DeleteDepartureAirportDto {
    @NotNull
    private UUID id;
}
