package com.turkcell.flightmanagementsystem.service.impl;

import com.turkcell.flightmanagementsystem.dto.flightrequest.CreateFlightRequestDto;
import com.turkcell.flightmanagementsystem.dto.flightrequest.DeleteFlightRequestDto;
import com.turkcell.flightmanagementsystem.dto.flightrequest.FlightRequestListiningDto;
import com.turkcell.flightmanagementsystem.dto.flightrequest.UpdateFlightRequestDto;
import com.turkcell.flightmanagementsystem.entity.Airline;
import com.turkcell.flightmanagementsystem.entity.airport.ArrivalAirport;
import com.turkcell.flightmanagementsystem.entity.airport.DepartureAirport;
import com.turkcell.flightmanagementsystem.entity.Flight;
import com.turkcell.flightmanagementsystem.repository.FlightRepository;
import com.turkcell.flightmanagementsystem.service.AirlineService;
import com.turkcell.flightmanagementsystem.service.AirportService;
import com.turkcell.flightmanagementsystem.service.FlightService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
//TODO:BELİRLİ BİR FORMAT NASIL ATILIR JAVA DA
//TODO:ABSTRACT CLASS OLARAK YAZ MAPPERLAR
//TODO: ENTİTY İSİMLERİNİ CONTROLLER,REPO SERVİCE DE OLUR
@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final AirlineService airlineService;
    private final AirportService airportService;

//buidwith
    public FlightServiceImpl(FlightRepository flightRepository,  AirlineService airlineService, AirportService airportService) {
        this.flightRepository = flightRepository;


        this.airlineService = airlineService;
        this.airportService = airportService;
    }

    @Override
    public Optional<Flight> findById(UUID id) {
        return flightRepository.findById(id);
    }


    @Override
    public void add(CreateFlightRequestDto createFlightRequestDto) {
        Airline airline=airlineService.findById(createFlightRequestDto.getAirlineId()).orElseThrow(()-> new RuntimeException("Airline Not Found"));
        ArrivalAirport arrivalAirport=airportService.findByArrivalAirportId(createFlightRequestDto.getArrivalAirportId()).orElseThrow(()-> new RuntimeException("Arrival Airport Not Found"));
        DepartureAirport departureAirport=airportService.findByDepartureAirportId(createFlightRequestDto.getDepartureAirportId()).orElseThrow(()-> new RuntimeException("Departure Airport Not Found"));

    //constructorı nesneyi oluştururken özelliklerini verebilirim
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

    //mapping not null eklenebilir ona bak
    //try-catch eklemeliyiz
    @Override
    public Flight update(UpdateFlightRequestDto updateFlightRequestDto) {
        Airline airline=airlineService.findById(updateFlightRequestDto.getAirlineId()).orElseThrow(()-> new RuntimeException("Airline Not Found"));
        ArrivalAirport arrivalAirport=airportService.findByArrivalAirportId(updateFlightRequestDto.getArrivalAirportId()).orElseThrow(()-> new RuntimeException("Arrival Airport Not Found"));
        DepartureAirport departureAirport=airportService.findByDepartureAirportId(updateFlightRequestDto.getDepartureAirportId()).orElseThrow(()-> new RuntimeException("Departure Airport Not Found"));
       Flight flight=flightRepository.findById(updateFlightRequestDto.getId()).orElse(null);
        flight.setStartDate(updateFlightRequestDto.getStartDate());
        flight.setEndDate(updateFlightRequestDto.getEndDate());
        flight.setAirline(airline);
        flight.setArrivalAirport(arrivalAirport);
        flight.setDepartureAirport(departureAirport);

        return flightRepository.save(flight);
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
