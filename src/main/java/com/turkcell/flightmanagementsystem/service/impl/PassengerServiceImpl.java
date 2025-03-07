package com.turkcell.flightmanagementsystem.service.impl;

import com.turkcell.flightmanagementsystem.dto.passenger.CreatePassengerDto;
import com.turkcell.flightmanagementsystem.dto.passenger.DeletePassengerDto;
import com.turkcell.flightmanagementsystem.dto.passenger.PassengerListiningDto;
import com.turkcell.flightmanagementsystem.dto.passenger.UpdatePassengerDto;
import com.turkcell.flightmanagementsystem.entity.Passenger;
import com.turkcell.flightmanagementsystem.repository.PassengerRepository;
import com.turkcell.flightmanagementsystem.service.PassengerService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public PassengerServiceImpl(PassengerRepository passengerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.passengerRepository = passengerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Optional<Passenger> findById(UUID id) {
        return passengerRepository.findById(id);
    }

    @Override
    public void add(CreatePassengerDto createPassengerDto) {
        Passenger passenger = new Passenger();
        passenger.setLuggage(createPassengerDto.getLuggage());
        passenger.setPassport(createPassengerDto.getPassport());
        passenger.setFirstName(createPassengerDto.getFirstName());
        passenger.setLastName(createPassengerDto.getLastName());
        passenger.setEmail(createPassengerDto.getEmail());
        passenger.setPhoneNumber(createPassengerDto.getPhoneNumber());
        passenger.setPassword(bCryptPasswordEncoder.encode(createPassengerDto.getPassword()));
        passengerRepository.save(passenger);

    }

    @Override
    public List<PassengerListiningDto> getAll() {
        List<PassengerListiningDto> PassengerListiningDtos = passengerRepository
                .findAll()
                .stream()
                .map((passenger)-> new PassengerListiningDto(passenger.getFirstName(),passenger.getLastName(),passenger.getEmail(),passenger.getPhoneNumber(),passenger.getLuggage(),passenger.getPassport()))
                .toList();
        return PassengerListiningDtos;
    }

    @Override
    public Passenger update(UpdatePassengerDto updatePassengerDto) {
        Passenger passenger = passengerRepository.findById(updatePassengerDto.getId()).orElseThrow(() ->new RuntimeException("Passenger not found"));
        passenger.setFirstName(updatePassengerDto.getFirstName());
        passenger.setLastName(updatePassengerDto.getLastName());
        passenger.setEmail(updatePassengerDto.getEmail());
        passenger.setPhoneNumber(updatePassengerDto.getPhoneNumber());
        passenger.setPassword(bCryptPasswordEncoder.encode(updatePassengerDto.getOldPassword()));
        passenger.setLuggage(updatePassengerDto.getLuggage());
        passenger.setPassport(updatePassengerDto.getPassport());

        return   passengerRepository.save(passenger);
    }

    @Override
    public void delete(DeletePassengerDto deletePassengerDto) {
        Passenger passenger=passengerRepository.findById(deletePassengerDto.getId()).orElseThrow(()->new RuntimeException("Passenger not found"));
        passengerRepository.delete(passenger);

    }

    public static class EmployeeServiceImpl {
    }
}
