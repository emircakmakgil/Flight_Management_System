package com.turkcell.flightmanagementsystem.controller;

import com.turkcell.flightmanagementsystem.dto.passenger.CreatePassengerDto;
import com.turkcell.flightmanagementsystem.dto.passenger.DeletePassengerDto;
import com.turkcell.flightmanagementsystem.dto.passenger.PassengerListiningDto;
import com.turkcell.flightmanagementsystem.dto.passenger.UpdatePassengerDto;
import com.turkcell.flightmanagementsystem.service.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/passengers")
public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody CreatePassengerDto createPassengerDto){
        this.passengerService.add(createPassengerDto);
    }
    @PutMapping
    @ResponseStatus(code=HttpStatus.OK)
    public void update(@RequestBody UpdatePassengerDto updatePassengerDto){
        this.passengerService.update(updatePassengerDto);
    }
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<PassengerListiningDto> getAllPassengers(){
        return  this.passengerService.getAll();
    }
    @DeleteMapping
    public void deletePassenger(@RequestBody DeletePassengerDto deletePassengerDto){
        this.passengerService.delete(deletePassengerDto);
    }
}
