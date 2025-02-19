package com.turkcell.flightmanagementsystem.dto.flightRequest;

import com.turkcell.flightmanagementsystem.entity.Airline;
import com.turkcell.flightmanagementsystem.entity.ArrivalAirport;
import com.turkcell.flightmanagementsystem.entity.DepartureAirport;

import java.time.LocalDate;
import java.util.UUID;


public class FlightRequestListiningDto {
    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    private DepartureAirport departureAirport;

    private Airline airline;
    private ArrivalAirport arrivalAirport;

    public FlightRequestListiningDto(UUID id, LocalDate startDate, LocalDate endDate, DepartureAirport departureAirport,
                                     Airline airline, ArrivalAirport arrivalAirport) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.departureAirport = departureAirport;
        this.airline = airline;
        this.arrivalAirport = arrivalAirport;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public DepartureAirport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(DepartureAirport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public ArrivalAirport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(ArrivalAirport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
}
