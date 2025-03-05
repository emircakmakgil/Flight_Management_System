package com.turkcell.flightmanagementsystem.repository;

import com.turkcell.flightmanagementsystem.entity.airport.DepartureAirport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartureAirportRepository extends JpaRepository<DepartureAirport, UUID> {
}
