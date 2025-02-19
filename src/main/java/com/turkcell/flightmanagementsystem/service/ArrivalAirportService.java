package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.entity.ArrivalAirport;

import java.util.Optional;
import java.util.UUID;

public interface ArrivalAirportService {
    Optional<ArrivalAirport> findById(UUID id);
}
