package com.example.loconav.flight.management.system.mapper;

import com.example.loconav.flight.management.system.entity.Ticket;
import com.example.loconav.flight.management.system.model.ticket.TicketRequest;
import com.example.loconav.flight.management.system.repo.IFlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    @Autowired
    private IFlightRepo flightRepo;

    public Ticket ticketRequestToTicket(TicketRequest ticketRequest) {
        return Ticket.builder().ticketNumber(ticketRequest.getTicketNumber())
                .userAge(ticketRequest.getUserAge())
                .userName(ticketRequest.getUserName())
                .userGender(ticketRequest.getUserGender())
                .flight(flightRepo.fetchFlight(ticketRequest.getFlightId())).build();
    }
}
