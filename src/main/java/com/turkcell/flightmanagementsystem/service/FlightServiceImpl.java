package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.dto.flightRequest.CreateFlightRequestDto;
import com.turkcell.flightmanagementsystem.dto.flightRequest.DeleteFlightRequestDto;
import com.turkcell.flightmanagementsystem.dto.flightRequest.FlightRequestListiningDto;
import com.turkcell.flightmanagementsystem.dto.flightRequest.UpdateFlightRequestDto;
import com.turkcell.flightmanagementsystem.entity.Airline;
import com.turkcell.flightmanagementsystem.entity.ArrivalAirport;
import com.turkcell.flightmanagementsystem.entity.DepartureAirport;
import com.turkcell.flightmanagementsystem.entity.Flight;
import com.turkcell.flightmanagementsystem.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final DepartureAirportService departureAirportService;
    private final ArrivalAirportService arrivalAirportService;
    private final AirlineService airlineService;


    public FlightServiceImpl(FlightRepository flightRepository, DepartureAirportService departureAirportService, ArrivalAirportService arrivalAirportService, AirlineService airlineService) {
        this.flightRepository = flightRepository;

        this.departureAirportService = departureAirportService;
        this.arrivalAirportService = arrivalAirportService;
        this.airlineService = airlineService;
    }

    @Override
    public Optional<Flight> findById(UUID id) {
        return flightRepository.findById(id);
    }

    @Override
    public void add(CreateFlightRequestDto createFlightRequestDto) {
        Airline airline=airlineService.findById(createFlightRequestDto.getAirlineId()).orElseThrow(()-> new RuntimeException("Airline Not Found"));
        ArrivalAirport arrivalAirport=arrivalAirportService.findById(createFlightRequestDto.getArrivalAirportId()).orElseThrow(()-> new RuntimeException("Arrival Airport Not Found"));
        DepartureAirport departureAirport=departureAirportService.findById(createFlightRequestDto.getDepartureAirportId()).orElseThrow(()-> new RuntimeException("Departure Airport Not Found"));


        Flight flight = new Flight();
        flight.setStartDate(createFlightRequestDto.getStartDate());
        flight.setEndDate(createFlightRequestDto.getEndDate());
        flight.setAirline(airline);
        flight.setArrivalAirport(arrivalAirport);
        flight.setDepartureAirport(departureAirport);
        flightRepository.save(flight);

    }

    @Override
    public List<FlightRequestListiningDto> getAll() {
        List<FlightRequestListiningDto> flightRequestListiningDtos = flightRepository
                .findAll()
                .stream()
                .map((flight) -> new FlightRequestListiningDto(flight.getId(),flight.getStartDate(),flight.getEndDate(),flight.getDepartureAirport(),flight.getAirline(),flight.getArrivalAirport()))
                .toList();

        return flightRequestListiningDtos;
    }



    @Override
    public Flight update(UpdateFlightRequestDto updateFlightRequestDto) {
        Airline airline=airlineService.findById(updateFlightRequestDto.getAirlineId()).orElseThrow(()-> new RuntimeException("Airline Not Found"));
        ArrivalAirport arrivalAirport=arrivalAirportService.findById(updateFlightRequestDto.getArrivalAirportId()).orElseThrow(()-> new RuntimeException("Arrival Airport Not Found"));
        DepartureAirport departureAirport=departureAirportService.findById(updateFlightRequestDto.getDepartureAirportId()).orElseThrow(()-> new RuntimeException("Departure Airport Not Found"));
       Flight flight1=flightRepository.findById(updateFlightRequestDto.getId()).orElse(null);
        flight1.setStartDate(updateFlightRequestDto.getStartDate());
        flight1.setEndDate(updateFlightRequestDto.getEndDate());
        flight1.setAirline(airline);
        flight1.setArrivalAirport(arrivalAirport);
        flight1.setDepartureAirport(departureAirport);

        return flightRepository.save(flight1);
    }

    @Override
    public void delete(DeleteFlightRequestDto deleteFlightRequestDto) {
        Flight flight1=flightRepository.findById(deleteFlightRequestDto.getId()).orElse(null);
        flightRepository.delete(flight1);
    }

    @Override
    public List<FlightRequestListiningDto> getFlightsByDate(UUID id, LocalDate startdate, LocalDate enddate) {
        return flightRepository.findById(id)
                .stream()
                .filter(flight -> (flight.getStartDate().isAfter(startdate) || flight.getStartDate().isEqual(startdate)) &&
                        (flight.getEndDate().isBefore(enddate) || flight.getEndDate().isEqual(enddate)))
                .map(flight -> new FlightRequestListiningDto(
                        flight.getId(),
                        flight.getStartDate(),
                        flight.getEndDate(),
                        flight.getDepartureAirport(),
                        flight.getAirline(),
                        flight.getArrivalAirport()))
                .toList();
    }

}
