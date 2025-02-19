package com.turkcell.flightmanagementsystem.repository;


import com.turkcell.flightmanagementsystem.entity.DepartureAirport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AirportRepository extends JpaRepository<DepartureAirport, UUID> {
}
