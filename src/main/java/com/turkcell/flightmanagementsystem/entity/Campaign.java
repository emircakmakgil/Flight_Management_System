package com.turkcell.flightmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@Entity
public class Campaign {

    @Id
    @UuidGenerator
    private UUID id;
    private String name;
    private String description;
    private double discountPercentage;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "campaign")
    private Set<Ticket> tickets;
}
