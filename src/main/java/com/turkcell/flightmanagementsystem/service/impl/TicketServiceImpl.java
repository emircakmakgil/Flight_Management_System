package com.turkcell.flightmanagementsystem.service.impl;

import com.turkcell.flightmanagementsystem.dto.ticket.*;
import com.turkcell.flightmanagementsystem.entity.Campaign;
import com.turkcell.flightmanagementsystem.entity.Flight;
import com.turkcell.flightmanagementsystem.entity.Ticket;
import com.turkcell.flightmanagementsystem.repository.TicketRepository;
import com.turkcell.flightmanagementsystem.service.CampaignService;
import com.turkcell.flightmanagementsystem.service.FlightService;
import com.turkcell.flightmanagementsystem.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
        private final TicketRepository ticketRepository;
        private final FlightService flightService;
        private final CampaignService campaignService;

        public TicketServiceImpl(TicketRepository ticketRepository, FlightService flightService,
                        CampaignService campaignService) {
                this.ticketRepository = ticketRepository;
                this.flightService = flightService;
                this.campaignService = campaignService;
        }

        @Override
        public void add(CreateTicketDto createTicketDto) {
                Flight flight = flightService.findById(createTicketDto.getFlightId())
                                .orElseThrow(() -> new RuntimeException("Flight not found"));
                Ticket ticket = new Ticket();
                ticket.setFlight(flight);
                ticket.setPrice(createTicketDto.getPrice());
                ticket.setSeatNo(createTicketDto.getSeatNo());
                ticket.setDiscounted(false);
                ticket.setDiscountRate(0.0);
                ticketRepository.save(ticket);
        }

        @Override
        public void delete(DeleteTicketDto deleteTicketDto) {
                Ticket ticket = ticketRepository.findById(deleteTicketDto.getId())
                                .orElseThrow(() -> new RuntimeException("Ticket not found"));
                ticketRepository.delete(ticket);
        }

        @Override
        public Ticket update(UpdateTicketDto updateTicketDto) {
                Flight flight = flightService.findById(updateTicketDto.getFlightId())
                                .orElseThrow(() -> new RuntimeException("Flight not found"));
                Campaign campaign = campaignService.findById(updateTicketDto.getCampaignId())
                                .orElseThrow(() -> new RuntimeException("Campaign not found"));
                Ticket ticket = ticketRepository.findById(updateTicketDto.getId())
                                .orElseThrow(() -> new RuntimeException("Ticket not found"));
                ticket.setPrice(updateTicketDto.getPrice());
                ticket.setSeatNo(updateTicketDto.getSeatNo());
                ticket.setFlight(flight);
                ticket.setCampaign(campaign);
                return ticketRepository.save(ticket);
        }

        @Override
        public List<TicketListiningDto> getAll() {
                return ticketRepository.findAll()
                                .stream()
                                .map(ticket -> {
                                        Flight flight = ticket.getFlight();
                                        if (flight == null) {
                                                throw new RuntimeException(
                                                                "Flight not found for ticket: " + ticket.getId());
                                        }
                                        return new TicketListiningDto(flight, ticket.getSeatNo(), ticket.getPrice());
                                })
                                .toList();
        }

        public Ticket createDiscountedTicket(CreateDiscountedTicketDto createTicketDto) {
                Campaign campaign = campaignService.findById(createTicketDto.getCampaignId())
                                .orElseThrow(() -> new RuntimeException("Campaign not found"));
                Flight flight = flightService.findById(createTicketDto.getFlightId())
                                .orElseThrow(() -> new RuntimeException("Flight not found"));

                double discountedPrice = calculateDiscountedPrice(createTicketDto.getPrice(),
                                campaign.getDiscountPercentage());

                Ticket ticket = new Ticket();
                ticket.setFlight(flight);
                ticket.setCampaign(campaign);
                ticket.setSeatNo(createTicketDto.getSeatNo());
                ticket.setPrice(discountedPrice);
                ticket.setDiscounted(true);
                ticket.setDiscountRate(campaign.getDiscountPercentage());
                return ticketRepository.save(ticket);
        }

        private double calculateDiscountedPrice(double originalPrice, double discountPercentage) {
                double discount = originalPrice * (discountPercentage / 100);
                return originalPrice - discount;
        }

        public List<DiscountedTicketListiningDto> getDiscountedTickets() {
                return ticketRepository.findAll()
                                .stream()
                                .filter(Ticket::isDiscounted)
                                .map(ticket -> new DiscountedTicketListiningDto(
                                                ticket.getSeatNo(),
                                                ticket.getPrice(),
                                                ticket.getDiscountRate(),
                                                ticket.getFlight().getId()))
                                .toList();
        }

        public List<DiscountedTicketListiningDto> getTicketsByDiscountRate(double discountRate) {
                return ticketRepository.findAll()
                                .stream()
                                .filter(ticket -> ticket.getDiscountRate() == discountRate)
                                .map(ticket -> new DiscountedTicketListiningDto(
                                                ticket.getSeatNo(),
                                                ticket.getPrice(),
                                                ticket.getDiscountRate(),
                                                ticket.getFlight().getId()))
                                .toList();
        }
}
