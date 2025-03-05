package com.turkcell.flightmanagementsystem.controller;

import com.turkcell.flightmanagementsystem.dto.flightrequest.CreateFlightRequestDto;
import com.turkcell.flightmanagementsystem.dto.flightrequest.DeleteFlightRequestDto;
import com.turkcell.flightmanagementsystem.dto.flightrequest.FlightRequestListiningDto;
import com.turkcell.flightmanagementsystem.dto.flightrequest.UpdateFlightRequestDto;
import com.turkcell.flightmanagementsystem.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<FlightRequestListiningDto> getAllFlights() {
        return this.flightService.getAll();
    }
    @PostMapping
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody CreateFlightRequestDto createFlightRequestDto) {
     this.flightService.add(createFlightRequestDto);
    }
    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody UpdateFlightRequestDto updateFlightRequestDto) {
        this.flightService.update(updateFlightRequestDto);
    }
    @DeleteMapping
    public void delete(@RequestBody DeleteFlightRequestDto deleteFlightRequestDto) {
        this.flightService.delete(deleteFlightRequestDto);
    }
    @GetMapping("/getFlightsByDate")
    public List<FlightRequestListiningDto> getFlightsByDate(
            @RequestParam UUID id,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        return flightService.getFlightsByDate(id, startDate, endDate);
    }
}
