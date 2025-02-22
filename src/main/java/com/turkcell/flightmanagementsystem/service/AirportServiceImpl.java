package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.entity.ArrivalAirport;
import com.turkcell.flightmanagementsystem.entity.DepartureAirport;
import com.turkcell.flightmanagementsystem.repository.ArrivalAirportRepository;
import com.turkcell.flightmanagementsystem.repository.DepartureAirportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class AirportServiceImpl implements AirportService {
    private final DepartureAirportRepository departureAirportRepository;
    private final ArrivalAirportRepository arrivalAirportRepository;

    public AirportServiceImpl(DepartureAirportRepository departureAirportRepository, ArrivalAirportRepository arrivalAirportRepository) {
        this.departureAirportRepository = departureAirportRepository;
        this.arrivalAirportRepository = arrivalAirportRepository;
    }

    @Override
    public Optional<DepartureAirport> findByDepartureAirportId(UUID id) {
        return departureAirportRepository.findById(id);
    }

    @Override
    public Optional<ArrivalAirport> findByArrivalAirportId(UUID id) {
        return arrivalAirportRepository.findById(id);
    }
}
