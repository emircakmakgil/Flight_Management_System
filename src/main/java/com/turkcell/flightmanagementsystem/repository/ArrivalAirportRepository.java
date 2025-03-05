package com.turkcell.flightmanagementsystem.repository;

import com.turkcell.flightmanagementsystem.entity.airport.ArrivalAirport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArrivalAirportRepository extends JpaRepository<ArrivalAirport, UUID> {
}
