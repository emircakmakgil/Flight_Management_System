package com.turkcell.flightmanagementsystem.repository;


import com.turkcell.flightmanagementsystem.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AirlineRepository extends JpaRepository<Airline, UUID> {
}
