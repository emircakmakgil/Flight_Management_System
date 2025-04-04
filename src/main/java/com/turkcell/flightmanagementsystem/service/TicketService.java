package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.dto.ticket.CreateTicketDto;
import com.turkcell.flightmanagementsystem.dto.ticket.DeleteTicketDto;
import com.turkcell.flightmanagementsystem.dto.ticket.TicketListiningDto;
import com.turkcell.flightmanagementsystem.dto.ticket.UpdateTicketDto;
import com.turkcell.flightmanagementsystem.dto.ticket.CreateDiscountedTicketDto;
import com.turkcell.flightmanagementsystem.dto.ticket.DiscountedTicketListiningDto;
import com.turkcell.flightmanagementsystem.entity.Ticket;

import java.util.List;

public interface TicketService {
    void add(CreateTicketDto createTicketDto);
    void delete(DeleteTicketDto deleteTicketDto);
    Ticket update(UpdateTicketDto updateTicketDto);
    List<TicketListiningDto> getAll();
    Ticket createDiscountedTicket(CreateDiscountedTicketDto createDiscountedTicketDto);
    List<DiscountedTicketListiningDto> getTicketsByDiscountRate(double discountRate);
    List<DiscountedTicketListiningDto> getDiscountedTickets();
}
