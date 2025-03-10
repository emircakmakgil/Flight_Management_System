package com.turkcell.flightmanagementsystem.dto.ticket;

import com.turkcell.flightmanagementsystem.entity.Flight;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
@Getter
@Setter
public class UpdateTicketDto {

    private UUID id;

    private String seatNo;

    @Min(value = 0, message = "Price must be greater than or equal to 0")
    private double price;

    private UUID flightId;
    private UUID campaignId;

}
