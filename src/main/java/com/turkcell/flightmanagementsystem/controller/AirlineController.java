package com.turkcell.flightmanagementsystem.controller;

import com.turkcell.flightmanagementsystem.dto.airline.AirlineListiningDto;
import com.turkcell.flightmanagementsystem.dto.airline.CreateAirlineDto;
import com.turkcell.flightmanagementsystem.dto.airline.DeleteAirlineDto;
import com.turkcell.flightmanagementsystem.dto.airline.UpdateAirlineDto;
import com.turkcell.flightmanagementsystem.entity.Airline;
import com.turkcell.flightmanagementsystem.service.AirlineService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/airlines")
public class AirlineController {
    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping
    @ResponseStatus(code= HttpStatus.OK)
    public List<AirlineListiningDto> getAirlines() {
        return this.airlineService.getAll();
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createAirline(@RequestBody CreateAirlineDto createAirlineDto) {
         this.airlineService.add(createAirlineDto);
    }
    @PutMapping
    @ResponseStatus(code=HttpStatus.OK)
    public void updateAirline(@RequestBody UpdateAirlineDto updateAirlineDto) {
        this.airlineService.update(updateAirlineDto);
    }
    @DeleteMapping
    @ResponseStatus(code=HttpStatus.OK)
    public void deleteAirline(@RequestBody DeleteAirlineDto deleteAirlineDto) {
        this.airlineService.delete(deleteAirlineDto);
    }



}
