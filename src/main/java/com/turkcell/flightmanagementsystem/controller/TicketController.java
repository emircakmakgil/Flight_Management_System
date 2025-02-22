package com.turkcell.flightmanagementsystem.controller;

import com.turkcell.flightmanagementsystem.dto.ticket.*;
import com.turkcell.flightmanagementsystem.entity.Ticket;
import com.turkcell.flightmanagementsystem.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody CreateTicketDto createTicketDto) {
        this.ticketService.add(createTicketDto);
    }
  /*  @PostMapping("/capmaign")
    @ResponseStatus(code= HttpStatus.CREATED)
    public void calculateCampaignPrice(@RequestBody CampaignTicketDto campaignTicketDto) {
        this.ticketService.calculateDiscountPrice(campaignTicketDto);
    } */
    @GetMapping //SOR
    public List<TicketListiningDto> getAll(){
        return this.ticketService.getAll();
    }
    @PutMapping
    public void update(@RequestBody UpdateTicketDto updateTicketDto) {
       this.ticketService.update(updateTicketDto);
    }
    @DeleteMapping
    public void delete(@RequestBody DeleteTicketDto deleteTicketDto) {
        this.ticketService.delete(deleteTicketDto);
    }
    @PostMapping("/discounted")
    public Ticket createDiscountedTicket(@Valid @RequestBody CreateDiscountedTicketDto createTicketDto) {
        Ticket createdTicket = ticketService.createDiscountedTicket(createTicketDto);
        return createdTicket;
    }
}
