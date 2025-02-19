package com.turkcell.flightmanagementsystem.repository;

import com.turkcell.flightmanagementsystem.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, UUID> {
}
