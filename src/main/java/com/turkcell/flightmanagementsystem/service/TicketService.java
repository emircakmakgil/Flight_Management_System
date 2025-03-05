package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.dto.ticket.*;
import com.turkcell.flightmanagementsystem.entity.Ticket;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface TicketService {
    void add(CreateTicketDto createTicketDto);
    void delete(DeleteTicketDto deleteTicketDto);
    Ticket update(UpdateTicketDto updateTicketDto);
    List<TicketListiningDto> getAll();
    Ticket createDiscountedTicket(CreateDiscountedTicketDto createDiscountedTicketDto);

    List<TicketListiningDto> getTicketsByDiscountRate(double discountRate);

    List<TicketListiningDto> getDiscountedTickets();
}
