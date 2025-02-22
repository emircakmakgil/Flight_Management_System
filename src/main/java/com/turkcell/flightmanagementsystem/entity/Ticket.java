package com.turkcell.flightmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
@Getter
@Setter
@Entity
public class Ticket {
    @Id
    @UuidGenerator
    private UUID id;
    @NotBlank
    private String seatNo;
    @NotNull
    private double price;

    @ManyToOne()
    @JoinColumn(name="flight_id")
    private Flight flight;

    @ManyToOne()
    @JoinColumn(name="campaign_id")
    private Campaign campaign;


}
