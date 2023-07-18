package com.example.loconav.flight.management.system.service;

import com.example.loconav.flight.management.system.model.ticket.TicketRequest;
import com.example.loconav.flight.management.system.model.ticket.TicketResponse;

public interface ITicketService {
    public TicketResponse createTicket(TicketRequest ticketRequest);
}
