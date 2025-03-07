package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.dto.passenger.*;
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
    String login(LoginPassengerDto loginPassengerDto);
    void updatePassword(ChangePassengerPasswordDto changePassengerPasswordDto);
}
