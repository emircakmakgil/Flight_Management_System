package com.turkcell.flightmanagementsystem.dto.ticket;

import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateDiscountedTicketDto {
    private String seatNo;

    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be greater than or equal to 0")
    private double price;


    private UUID flightId;
    private UUID campaignId;
    private boolean isDiscounted;
    private double discountPercentage;






}
