package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.dto.flightRequest.CreateFlightRequestDto;
import com.turkcell.flightmanagementsystem.dto.flightRequest.DeleteFlightRequestDto;
import com.turkcell.flightmanagementsystem.dto.flightRequest.FlightRequestListiningDto;
import com.turkcell.flightmanagementsystem.dto.flightRequest.UpdateFlightRequestDto;
import com.turkcell.flightmanagementsystem.entity.Flight;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
//TODO: SON 1 AY YURT İÇİ İNCELE ŞEHİR ÜLKE ZORUNLU OLMAYAN PARAMETRE VEREBİLİRİM
public interface FlightService {
    Optional<Flight> findById(UUID id);
    void add(CreateFlightRequestDto createFlightRequestDto);
    List<FlightRequestListiningDto> getAll();
    Flight update(UpdateFlightRequestDto updateFlightRequestDto);
    void delete(DeleteFlightRequestDto deleteFlightRequestDto);
    List<FlightRequestListiningDto>  getFlightsByDate(UUID id,LocalDate startdate, LocalDate enddate);

}
