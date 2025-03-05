package com.turkcell.flightmanagementsystem.dto.flightrequest;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter

public class UpdateFlightRequestDto {

    private UUID id;

    @NotBlank
    private LocalDate startDate;

    @NotBlank
    private LocalDate endDate;

    @NotBlank
    private UUID airlineId;

    @NotBlank
    private UUID arrivalAirportId;

    @NotBlank
    private UUID departureAirportId;


}
