package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.dto.flightrequest.CreateFlightRequestDto;
import com.turkcell.flightmanagementsystem.dto.flightrequest.DeleteFlightRequestDto;
import com.turkcell.flightmanagementsystem.dto.flightrequest.FlightRequestListiningDto;
import com.turkcell.flightmanagementsystem.dto.flightrequest.UpdateFlightRequestDto;
import com.turkcell.flightmanagementsystem.entity.Flight;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface FlightService {
    Optional<Flight> findById(UUID id);
    void add(CreateFlightRequestDto createFlightRequestDto);
    List<FlightRequestListiningDto> getAll();
    Flight update(UpdateFlightRequestDto updateFlightRequestDto);
    void delete(DeleteFlightRequestDto deleteFlightRequestDto);
    List<FlightRequestListiningDto>  getFlightsByDate(UUID id,LocalDate startdate, LocalDate enddate);

}
