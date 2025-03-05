package com.turkcell.flightmanagementsystem.controller;

import com.turkcell.flightmanagementsystem.dto.arrivalAirport.ArrivalAirportListiningDto;
import com.turkcell.flightmanagementsystem.dto.arrivalAirport.CreateArrivalAirportDto;
import com.turkcell.flightmanagementsystem.dto.arrivalAirport.DeleteArrivalAirportDto;
import com.turkcell.flightmanagementsystem.dto.arrivalAirport.UpdateArrivalAirportDto;
import com.turkcell.flightmanagementsystem.dto.departureAirport.CreateDepartureAirportDto;
import com.turkcell.flightmanagementsystem.dto.departureAirport.DeleteDepartureAirportDto;
import com.turkcell.flightmanagementsystem.dto.departureAirport.DepartureAirportListiningDto;
import com.turkcell.flightmanagementsystem.dto.departureAirport.UpdateDepartureAirportDto;
import com.turkcell.flightmanagementsystem.entity.airport.ArrivalAirport;
import com.turkcell.flightmanagementsystem.service.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airports")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }
    @GetMapping("/arrivalAirport")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ArrivalAirportListiningDto> getAllArrivalAirports() {
        return this.airportService.getAllArrivalAirports();
    }
    @GetMapping("/departureAirport")
    @ResponseStatus(code = HttpStatus.OK)
    public List<DepartureAirportListiningDto> getAllDepartureAirports() {
        return this.airportService.getAllDepartureAirports();
    }
    @PostMapping("/arrivalAirport")
    @ResponseStatus(code=HttpStatus.CREATED)
    public void createArrivalAirport(@RequestBody CreateArrivalAirportDto arrivalAirport) {
        this.airportService.addArrivalAirport(arrivalAirport);
    }
    @PostMapping("/departureAirport")
    @ResponseStatus(code=HttpStatus.CREATED)
    public void createDepartureAirport(@RequestBody CreateDepartureAirportDto departureAirport) {
        this.airportService.addDepartureAirport(departureAirport);
    }
    @PutMapping("/arrivalAirport")
    @ResponseStatus(code=HttpStatus.OK)
    public void updateArrivalAirport(@RequestBody UpdateArrivalAirportDto arrivalAirport) {
        this.airportService.updateArrivalAirport(arrivalAirport);
    }
    @PutMapping("/departureAirport")
    @ResponseStatus(code=HttpStatus.OK)
    public void updateDepartureAirport(@RequestBody UpdateDepartureAirportDto departureAirport) {
        this.airportService.updateDepartureAirport(departureAirport);
    }
    @DeleteMapping("/arrivalAirport")
    @ResponseStatus(code=HttpStatus.OK)
    public void deleteArrivalAirport(@RequestBody DeleteArrivalAirportDto arrivalAirport) {
        this.airportService.deleteArrivalAirport(arrivalAirport);
    }
    @DeleteMapping("/departureAirport")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteDepartureAirport(@RequestBody DeleteDepartureAirportDto departureAirport) {
        this.airportService.deleteDepartureAirport(departureAirport);
    }
}
