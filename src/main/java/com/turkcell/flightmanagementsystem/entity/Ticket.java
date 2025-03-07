package com.turkcell.flightmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

//TODO:USER EKLE NOT NULL
//TODO: TİCKET HİSTORY LOG (SELF REFERANCE USER TİCKET HAVAYOLU BAĞLANTILARI KAMPANYA KOLUNU EKLE)

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
    private boolean isDiscounted;
    @NotNull
    @Column(name = "discount_rate")
    private double discountRate;

    @ManyToOne()
    @JoinColumn(name = "flight_id")
    private Flight flight;

    // kampanya ismi de verilebilir
    @ManyToOne()
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

}
