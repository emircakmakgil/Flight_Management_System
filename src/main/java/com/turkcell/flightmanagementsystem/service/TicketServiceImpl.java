package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.dto.ticket.*;
import com.turkcell.flightmanagementsystem.entity.Campaign;
import com.turkcell.flightmanagementsystem.entity.Flight;
import com.turkcell.flightmanagementsystem.entity.Ticket;
import com.turkcell.flightmanagementsystem.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final FlightService flightService;
    private final CampaignService campaignService;

    public TicketServiceImpl(TicketRepository ticketRepository, FlightService flightService, CampaignService campaignService) {
        this.ticketRepository = ticketRepository;
        this.flightService = flightService;
        this.campaignService = campaignService;
    }

    @Override
    public void add(CreateTicketDto createTicketDto) {
        Flight flight=flightService.findById(createTicketDto.getFlightId()).orElseThrow(()->new RuntimeException("Flight not found"));
        Ticket ticket=new Ticket();
        ticket.setFlight(flight);
        ticket.setPrice(createTicketDto.getPrice());
        ticket.setSeatNo(createTicketDto.getSeatNo());
        ticket.setPrice(createTicketDto.getPrice());
        ticketRepository.save(ticket);

    }

    @Override
    public void delete(DeleteTicketDto deleteTicketDto) {
        Ticket ticket=ticketRepository.findById(deleteTicketDto.getId()).orElseThrow(()->new RuntimeException("Ticket not found"));
        ticketRepository.delete(ticket);

    }

    @Override
    public Ticket update(UpdateTicketDto updateTicketDto) {
        Flight flight=flightService.findById(updateTicketDto.getFlightId()).orElseThrow(()->new RuntimeException("Flight not found"));
        Campaign campaign=campaignService.findById(updateTicketDto.getCampaignId()).orElseThrow(()->new RuntimeException("Campaign not found"));
        Ticket ticket=ticketRepository.findById(updateTicketDto.getId()).orElseThrow(()->new RuntimeException("Ticket not found"));
        ticket.setPrice(updateTicketDto.getPrice());
        ticket.setSeatNo(updateTicketDto.getSeatNo());
        ticket.setPrice(updateTicketDto.getPrice());
        ticket.setFlight(flight);
        ticket.setCampaign(campaign);
        return ticketRepository.save(ticket);
    }

    @Override
    public List<TicketListiningDto> getAll() {
        List<TicketListiningDto> updateTicketDtoList=ticketRepository
                .findAll()
                .stream()
                .map((ticket)-> new TicketListiningDto(ticket.getFlight(),ticket.getSeatNo(),ticket.getPrice()))
                .toList();
        return updateTicketDtoList;
    }
    public Ticket createDiscountedTicket(CreateDiscountedTicketDto createTicketDto) {
        Campaign campaign = campaignService.findById(createTicketDto.getCampaignId())
                .orElseThrow(() -> new RuntimeException("Campaign not found"));
        Flight flight =flightService.findById(createTicketDto.getFlightId()).orElseThrow(()->new RuntimeException("Flight not found"));

        // İndirimli fiyatı hesapla
        double discountedPrice = calculateDiscountedPrice(createTicketDto.getPrice(), campaign.getDiscountPercentage());

        Ticket ticket = new Ticket();
        ticket.setFlight(flight);
        ticket.setCampaign(campaign);
        ticket.setSeatNo(createTicketDto.getSeatNo());
        ticket.setPrice(discountedPrice);

        return ticketRepository.save(ticket);
    }



    private double calculateDiscountedPrice(double originalPrice, double discountPercentage) {
        double discount = originalPrice * (discountPercentage / 100);
        return originalPrice - discount;
    }
}







