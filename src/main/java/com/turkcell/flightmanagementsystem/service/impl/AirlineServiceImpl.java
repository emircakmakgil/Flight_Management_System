package com.turkcell.flightmanagementsystem.service.impl;

import com.turkcell.flightmanagementsystem.dto.airline.AirlineListiningDto;
import com.turkcell.flightmanagementsystem.dto.airline.CreateAirlineDto;
import com.turkcell.flightmanagementsystem.dto.airline.DeleteAirlineDto;
import com.turkcell.flightmanagementsystem.dto.airline.UpdateAirlineDto;
import com.turkcell.flightmanagementsystem.entity.Airline;
import com.turkcell.flightmanagementsystem.repository.AirlineRepository;
import com.turkcell.flightmanagementsystem.service.AirlineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AirlineServiceImpl implements AirlineService {

    private final AirlineRepository airlineRepository;

    public AirlineServiceImpl(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public Optional<Airline> findById(UUID id) {
        return airlineRepository.findById(id);
    }

    @Override
    public void add(CreateAirlineDto createAirlineDto) {
        Airline airline=new Airline();
        airline.setCode(createAirlineDto.getCode());
        airline.setName(createAirlineDto.getName());
        airline.setCountry(createAirlineDto.getCountry());
        airlineRepository.save(airline);
    }

    @Override
    public List<AirlineListiningDto> getAll() {
           List<AirlineListiningDto> AirlineListiningDtos=airlineRepository
               .findAll()
               .stream()
               .map((airline)->new AirlineListiningDto(airline.getId(),airline.getCode(),airline.getName(),airline.getCountry()))
                   .toList();
           return AirlineListiningDtos;
    }

    @Override
    public Airline update(UpdateAirlineDto updateAirlineDto) {
        Airline airline=airlineRepository.findById(updateAirlineDto.getId()).orElseThrow(()->new RuntimeException("Airline not found"));
        airline.setName(updateAirlineDto.getName());
        airline.setCountry(updateAirlineDto.getCountry());
        airline.setCode(updateAirlineDto.getCode());


        return airlineRepository.save(airline);
    }

    @Override
    public void delete(DeleteAirlineDto deleteAirlineDto) {
        Airline airline=airlineRepository.findById(deleteAirlineDto.getId()).orElseThrow(()->new RuntimeException("Airline not found"));
        airlineRepository.delete(airline);

    }
}
