package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.entity.ArrivalAirport;
import com.turkcell.flightmanagementsystem.repository.ArrivalAirportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ArrivalAirportServiceImpl implements ArrivalAirportService {
    private final ArrivalAirportRepository arrivalAirportRepository;

    public ArrivalAirportServiceImpl(ArrivalAirportRepository arrivalAirportRepository) {
        this.arrivalAirportRepository = arrivalAirportRepository;
    }

    @Override
    public Optional<ArrivalAirport> findById(UUID id) {
        return arrivalAirportRepository.findById(id);
    }
}
