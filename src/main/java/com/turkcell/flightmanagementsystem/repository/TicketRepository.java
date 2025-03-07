package com.turkcell.flightmanagementsystem.repository;

import com.turkcell.flightmanagementsystem.dto.ticket.TicketListiningDto;
import com.turkcell.flightmanagementsystem.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    List<TicketListiningDto> findByIsDiscountedTrue();

    List<TicketListiningDto> findByDiscountRate(double discountRate);
}
