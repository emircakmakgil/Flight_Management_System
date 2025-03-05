package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.dto.airline.AirlineListiningDto;
import com.turkcell.flightmanagementsystem.dto.airline.CreateAirlineDto;
import com.turkcell.flightmanagementsystem.dto.airline.DeleteAirlineDto;
import com.turkcell.flightmanagementsystem.dto.airline.UpdateAirlineDto;
import com.turkcell.flightmanagementsystem.dto.arrivalAirport.ArrivalAirportListiningDto;
import com.turkcell.flightmanagementsystem.dto.arrivalAirport.CreateArrivalAirportDto;
import com.turkcell.flightmanagementsystem.dto.arrivalAirport.DeleteArrivalAirportDto;
import com.turkcell.flightmanagementsystem.dto.arrivalAirport.UpdateArrivalAirportDto;
import com.turkcell.flightmanagementsystem.dto.departureAirport.CreateDepartureAirportDto;
import com.turkcell.flightmanagementsystem.dto.departureAirport.DeleteDepartureAirportDto;
import com.turkcell.flightmanagementsystem.dto.departureAirport.DepartureAirportListiningDto;
import com.turkcell.flightmanagementsystem.dto.departureAirport.UpdateDepartureAirportDto;
import com.turkcell.flightmanagementsystem.entity.Airline;
import com.turkcell.flightmanagementsystem.entity.airport.ArrivalAirport;
import com.turkcell.flightmanagementsystem.entity.airport.DepartureAirport;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AirportService {

    void addArrivalAirport(CreateArrivalAirportDto createArrivalAirportDto);
    void addDepartureAirport(CreateDepartureAirportDto createDepartureAirportDto);
    List<ArrivalAirportListiningDto> getAllArrivalAirports();
    List<DepartureAirportListiningDto> getAllDepartureAirports();
    ArrivalAirport updateArrivalAirport(UpdateArrivalAirportDto updateArrivalAirportDto);
    DepartureAirport updateDepartureAirport(UpdateDepartureAirportDto updateDepartureAirportDto);
    void deleteArrivalAirport(DeleteArrivalAirportDto deleteArrivalAirportDto);
    void deleteDepartureAirport(DeleteDepartureAirportDto deleteDepartureAirportDto);



    Optional<DepartureAirport> findByDepartureAirportId(UUID id);
    Optional<ArrivalAirport> findByArrivalAirportId(UUID id);

}
