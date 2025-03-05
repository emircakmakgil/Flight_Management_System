package com.turkcell.flightmanagementsystem.dto.arrivalAirport;

import com.turkcell.flightmanagementsystem.entity.Flight;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;
@Getter
@Setter
public class DeleteArrivalAirportDto {
    @NotNull
    private UUID id;


}
