package com.turkcell.flightmanagementsystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

//id | name | location
@Entity
@Table(name="departure_airport")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartureAirport {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name="airport_name")
    private String name;


    private String location;

    @OneToMany(mappedBy = "departureAirport")
    private Set<Flight> flights;


}
