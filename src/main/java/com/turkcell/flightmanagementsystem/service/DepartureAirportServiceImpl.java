package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.entity.DepartureAirport;
import com.turkcell.flightmanagementsystem.repository.DepartureAirportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DepartureAirportServiceImpl implements DepartureAirportService {
    private final DepartureAirportRepository departureAirportRepository;

    public DepartureAirportServiceImpl(DepartureAirportRepository departureAirportRepository) {
        this.departureAirportRepository = departureAirportRepository;
    }

    @Override
    public Optional<DepartureAirport> findById(UUID id) {
        return departureAirportRepository.findById(id);
    }
}
