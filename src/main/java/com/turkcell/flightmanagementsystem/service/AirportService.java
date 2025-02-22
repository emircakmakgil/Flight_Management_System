package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.entity.ArrivalAirport;
import com.turkcell.flightmanagementsystem.entity.DepartureAirport;

import java.util.Optional;
import java.util.UUID;

public interface AirportService {
    Optional<DepartureAirport> findByDepartureAirportId(UUID id);
    Optional<ArrivalAirport> findByArrivalAirportId(UUID id);

}
