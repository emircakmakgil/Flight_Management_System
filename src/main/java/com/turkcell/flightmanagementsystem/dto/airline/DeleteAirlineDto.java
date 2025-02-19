package com.turkcell.flightmanagementsystem.dto.airline;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DeleteAirlineDto {
    @NotNull()
    private UUID id;
}
