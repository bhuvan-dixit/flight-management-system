package com.example.loconav.flight.management.system.service.impl;

import com.example.loconav.flight.management.system.constants.TicketConstant;
import com.example.loconav.flight.management.system.entity.Ticket;
import com.example.loconav.flight.management.system.mapper.FlightMapper;
import com.example.loconav.flight.management.system.mapper.TicketMapper;
import com.example.loconav.flight.management.system.service.ITicketService;
import com.example.loconav.flight.management.system.model.ticket.TicketRequest;
import com.example.loconav.flight.management.system.model.ticket.TicketResponse;
import com.example.loconav.flight.management.system.repo.ITicketRepo;
import com.example.loconav.flight.management.system.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private ITicketRepo ticketRepo;

    @Autowired
    private FlightMapper flightMapper;

    @Autowired
    private IFlightService flightService;

    @Autowired
    private TicketMapper ticketMapper;

    /***
     *
     * @param ticketRequest
     * @return
     */
    @Transactional
    public TicketResponse createTicket(TicketRequest ticketRequest) {
        System.out.println(ticketRequest);
        if(flightService.fetchAvailableSeats(ticketRequest.getFlightId()) == 0) {
            return TicketResponse.builder().response(TicketConstant.UNABLE_TO_BOOK_SEATS).build();
        }
        Ticket ticket  = ticketMapper.ticketRequestToTicket(ticketRequest);
        ticket.getFlight().setNumberOfBookedSeats(ticket.getFlight().getNumberOfBookedSeats()+1);
        ticketRepo.save(ticket);
        return TicketResponse.builder().response("Success").build();
    }
}
