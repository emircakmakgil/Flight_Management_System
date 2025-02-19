package com.turkcell.flightmanagementsystem.repository;

import com.turkcell.flightmanagementsystem.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PassengerRepository extends JpaRepository<Passenger, UUID> {
}
