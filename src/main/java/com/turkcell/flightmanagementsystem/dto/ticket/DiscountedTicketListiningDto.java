package com.turkcell.flightmanagementsystem.dto.ticket;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class DiscountedTicketListiningDto {
    @NotBlank
    private String seatNo;
    @NotNull
    private double price;
    private UUID flightId;
    private boolean isDiscounted;
    @NotNull
    private double discountRate;

    public DiscountedTicketListiningDto(@NotBlank String seatNo, @NotNull double price, @NotNull double discountRate, UUID id) {
        this.seatNo = seatNo;
        this.price = price;
        this.isDiscounted = true;
        this.discountRate = discountRate;
        this.flightId = id;
    }
}
