package com.turkcell.flightmanagementsystem.entity.airport;


import com.turkcell.flightmanagementsystem.entity.Flight;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

//id | name | location
@Entity
@Table(name="departure_airport")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartureAirport extends Airport {


    @OneToMany(mappedBy = "departureAirport")
    private Set<Flight> flights;


}
