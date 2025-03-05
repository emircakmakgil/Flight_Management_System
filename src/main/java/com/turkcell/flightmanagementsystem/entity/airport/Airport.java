package com.turkcell.flightmanagementsystem.entity.airport;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Airport {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(name="airport_name")
    private String name;


    private String location;


}
