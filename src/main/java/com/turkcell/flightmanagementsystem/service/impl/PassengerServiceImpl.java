package com.turkcell.flightmanagementsystem.service.impl;

import com.turkcell.flightmanagementsystem.core.exception.jwt.JwtService;
import com.turkcell.flightmanagementsystem.dto.passenger.*;
import com.turkcell.flightmanagementsystem.entity.Passenger;
import com.turkcell.flightmanagementsystem.repository.PassengerRepository;
import com.turkcell.flightmanagementsystem.rules.PassengerBusinessRules;
import com.turkcell.flightmanagementsystem.service.PassengerService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;
    private final PassengerBusinessRules passengerBusinessRules;


    public PassengerServiceImpl(PassengerRepository passengerRepository, BCryptPasswordEncoder bCryptPasswordEncoder, JwtService jwtService, PassengerBusinessRules passengerBusinessRules) {
        this.passengerRepository = passengerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtService = jwtService;
        this.passengerBusinessRules = passengerBusinessRules;
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

    @Override
    public String login(LoginPassengerDto loginPassengerDto) {
        Optional<Passenger> optionalPassenger=passengerRepository.findByEmail(loginPassengerDto.getEmail());
        passengerBusinessRules.ValidatePassenger(optionalPassenger,loginPassengerDto);
        return jwtService.generateToken(loginPassengerDto.getEmail());

    }

    @Override
    public void updatePassword(ChangePassengerPasswordDto changePassengerPasswordDto) {
        Optional<Passenger> optionalPassenger=passengerRepository.findByEmail(changePassengerPasswordDto.getEmail());
        passengerBusinessRules.ValidatePassenger(optionalPassenger,changePassengerPasswordDto);
        Passenger passenger=optionalPassenger.get();
        passenger.setPassword(bCryptPasswordEncoder.encode(changePassengerPasswordDto.getNewPassword()));
        passenger.setUpdatedAt(new Date(System.currentTimeMillis()));

        passengerRepository.save(passenger);

    }


}
