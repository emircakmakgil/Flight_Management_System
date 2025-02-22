package com.turkcell.flightmanagementsystem.dto.ticket;

import com.turkcell.flightmanagementsystem.entity.Flight;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketListiningDto {

    @NotBlank
    private String seatNo;
    @NotNull
    private double price;

    private Flight flight;

    public TicketListiningDto(Flight flight, @NotBlank String seatNo, @NotNull double price) {
        this.seatNo = seatNo;
        this.price = price;
        this.flight = flight;
    }
}
