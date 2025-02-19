package com.turkcell.flightmanagementsystem.service;


import com.turkcell.flightmanagementsystem.dto.airline.AirlineListiningDto;
import com.turkcell.flightmanagementsystem.dto.airline.CreateAirlineDto;
import com.turkcell.flightmanagementsystem.dto.airline.DeleteAirlineDto;
import com.turkcell.flightmanagementsystem.dto.airline.UpdateAirlineDto;
import com.turkcell.flightmanagementsystem.entity.Airline;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AirlineService {
    Optional<Airline> findById(UUID id);
    void add(CreateAirlineDto createAirlineDto);
    List<AirlineListiningDto> getAll();
    Airline update(UpdateAirlineDto updateAirlineDto);
    void delete(DeleteAirlineDto deleteAirlineDto);
}
