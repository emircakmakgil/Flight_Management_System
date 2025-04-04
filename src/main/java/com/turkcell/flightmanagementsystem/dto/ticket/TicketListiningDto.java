package com.turkcell.flightmanagementsystem.dto.ticket;

import com.turkcell.flightmanagementsystem.entity.Flight;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TicketListiningDto {

    @NotBlank
    private String seatNo;
    @NotNull
    private double price;
    private boolean isDiscounted;
    private double discountRate;
    private UUID flightId;

    public TicketListiningDto(Flight flight, @NotBlank String seatNo, @NotNull double price) {
        this.seatNo = seatNo;
        this.price = price;
        this.isDiscounted = false;
        this.discountRate = 0.0;
        this.flightId = flight.getId();
    }

    // No-args constructor for serialization
    public TicketListiningDto() {
    }
}
