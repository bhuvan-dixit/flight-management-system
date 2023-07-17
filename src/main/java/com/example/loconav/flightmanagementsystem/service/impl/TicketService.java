package com.example.loconav.flightmanagementsystem.service.impl;

import com.example.loconav.flightmanagementsystem.entity.Ticket;
import com.example.loconav.flightmanagementsystem.mapper.FlightMapper;
import com.example.loconav.flightmanagementsystem.model.ticket.TicketRequest;
import com.example.loconav.flightmanagementsystem.model.ticket.TicketResponse;
import com.example.loconav.flightmanagementsystem.repo.ITicketRepo;
import com.example.loconav.flightmanagementsystem.service.IFlightService;
import com.example.loconav.flightmanagementsystem.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepo ticketRepo;

    @Autowired
    private FlightMapper flightMapper;

    @Autowired
    private IFlightService flightService;

    public TicketResponse bookTicket(TicketRequest ticketRequest) {
        if(flightService.getAvailableSeats(ticketRequest.getFlightId()) == 0) {
            return TicketResponse.builder().response("Unable to book Ticket. All seats booked.").build();
        }
        Ticket ticket  = flightMapper.TicketRequestToTicket(ticketRequest);
        ticketRepo.save(ticket);
        return TicketResponse.builder().response("Success").build();
    }
}
