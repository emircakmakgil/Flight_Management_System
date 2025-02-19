package com.turkcell.flightmanagementsystem.dto.flightRequest;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DeleteFlightRequestDto {
    @NotNull()
    private UUID id;
}
