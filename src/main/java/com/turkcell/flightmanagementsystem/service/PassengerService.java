package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.dto.passenger.CreatePassengerDto;
import com.turkcell.flightmanagementsystem.dto.passenger.DeletePassengerDto;
import com.turkcell.flightmanagementsystem.dto.passenger.PassengerListiningDto;
import com.turkcell.flightmanagementsystem.dto.passenger.UpdatePassengerDto;
import com.turkcell.flightmanagementsystem.entity.Passenger;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PassengerService {
    Optional<Passenger> findById(UUID id);
    void add(CreatePassengerDto createPassengerDto);
    List<PassengerListiningDto> getAll();
    Passenger update(UpdatePassengerDto updatePassengerDto);
    void delete(DeletePassengerDto deletePassengerDto);
}
