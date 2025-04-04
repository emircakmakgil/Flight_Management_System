package com.turkcell.flightmanagementsystem.service.impl;

import com.turkcell.flightmanagementsystem.dto.arrivalAirport.ArrivalAirportListiningDto;
import com.turkcell.flightmanagementsystem.dto.arrivalAirport.CreateArrivalAirportDto;
import com.turkcell.flightmanagementsystem.dto.arrivalAirport.DeleteArrivalAirportDto;
import com.turkcell.flightmanagementsystem.dto.arrivalAirport.UpdateArrivalAirportDto;
import com.turkcell.flightmanagementsystem.dto.departureAirport.CreateDepartureAirportDto;
import com.turkcell.flightmanagementsystem.dto.departureAirport.DeleteDepartureAirportDto;
import com.turkcell.flightmanagementsystem.dto.departureAirport.DepartureAirportListiningDto;
import com.turkcell.flightmanagementsystem.dto.departureAirport.UpdateDepartureAirportDto;
import com.turkcell.flightmanagementsystem.entity.airport.ArrivalAirport;
import com.turkcell.flightmanagementsystem.entity.airport.DepartureAirport;
import com.turkcell.flightmanagementsystem.repository.ArrivalAirportRepository;
import com.turkcell.flightmanagementsystem.repository.DepartureAirportRepository;
import com.turkcell.flightmanagementsystem.service.AirportService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AirportServiceImpl implements AirportService {
    private final DepartureAirportRepository departureAirportRepository;
    private final ArrivalAirportRepository arrivalAirportRepository;
    public AirportServiceImpl(DepartureAirportRepository departureAirportRepository, ArrivalAirportRepository arrivalAirportRepository) {
        this.departureAirportRepository = departureAirportRepository;
        this.arrivalAirportRepository = arrivalAirportRepository;

    }



    @Override
    public void addArrivalAirport(CreateArrivalAirportDto createArrivalAirportDto) {
        ArrivalAirport arrivalAirport = new ArrivalAirport();
        arrivalAirport.setName(createArrivalAirportDto.getName());
        arrivalAirport.setLocation(createArrivalAirportDto.getLocation());
        arrivalAirportRepository.save(arrivalAirport);
    }

    @Override
    public void addDepartureAirport(CreateDepartureAirportDto createDepartureAirportDto) {
        DepartureAirport departureAirport = new DepartureAirport();
        departureAirport.setName(createDepartureAirportDto.getName());
        departureAirport.setLocation(createDepartureAirportDto.getLocation());
        departureAirportRepository.save(departureAirport);

    }

    @Override
    public List<ArrivalAirportListiningDto> getAllArrivalAirports() {
        List<ArrivalAirportListiningDto> arrivalAirportListiningDtos=
                arrivalAirportRepository
                        .findAll()
                        .stream()
                        .map((airport) -> new ArrivalAirportListiningDto(airport.getName(),airport.getLocation()))
                        .toList();
        return arrivalAirportListiningDtos;
    }

    @Override
    public List<DepartureAirportListiningDto> getAllDepartureAirports() {
        List<DepartureAirportListiningDto> departureAirportListiningDtos=departureAirportRepository
                .findAll()
                .stream()
                .map((airport)-> new DepartureAirportListiningDto(airport.getName(),airport.getLocation()))
                .toList();
        return departureAirportListiningDtos;
    }

    @Override
    public ArrivalAirport updateArrivalAirport(UpdateArrivalAirportDto updateArrivalAirportDto) {
        ArrivalAirport arrivalAirport = arrivalAirportRepository.findById(updateArrivalAirportDto.getId()).orElseThrow(() -> new RuntimeException("Arrival Airport Not Found"));
        arrivalAirport.setName(updateArrivalAirportDto.getName());
        arrivalAirport.setLocation(updateArrivalAirportDto.getLocation());
        arrivalAirport.setFlights(arrivalAirport.getFlights());
        return arrivalAirportRepository.save(arrivalAirport);
    }

    @Override
    public DepartureAirport updateDepartureAirport(UpdateDepartureAirportDto updateDepartureAirportDto) {
        DepartureAirport departureAirport=departureAirportRepository.findById(updateDepartureAirportDto.getId()).orElseThrow(() -> new RuntimeException("Departure Airport Not Found"));
        departureAirport.setName(updateDepartureAirportDto.getName());
        departureAirport.setLocation(updateDepartureAirportDto.getLocation());
        departureAirport.setFlights(departureAirport.getFlights());

        return departureAirportRepository.save(departureAirport);
    }

    @Override
    public void deleteArrivalAirport(DeleteArrivalAirportDto deleteArrivalAirportDto) {
        ArrivalAirport arrivalAirport=arrivalAirportRepository.findById(deleteArrivalAirportDto.getId()).orElseThrow(()-> new RuntimeException("Arrival Airport Not Found"));
        arrivalAirportRepository.delete(arrivalAirport);
    }

    @Override
    public void deleteDepartureAirport(DeleteDepartureAirportDto deleteDepartureAirportDto) {
        DepartureAirport departureAirport=departureAirportRepository.findById(deleteDepartureAirportDto.getId()).orElseThrow(() -> new RuntimeException("Departure Airport Not Found"));
        departureAirportRepository.delete(departureAirport);


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
