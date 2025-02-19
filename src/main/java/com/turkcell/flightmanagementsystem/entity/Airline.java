package com.turkcell.flightmanagementsystem.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

//id | name
@Entity
@Table(name="airlines")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Airline {
    @Id
    @UuidGenerator
    private UUID id;
    private String code;
    private String name;
    private String country;

    @OneToMany(mappedBy = "airline")
    private Set<Flight> flights;

}
