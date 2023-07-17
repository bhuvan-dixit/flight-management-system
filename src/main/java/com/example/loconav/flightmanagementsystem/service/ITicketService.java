package com.example.loconav.flightmanagementsystem.service;

import com.example.loconav.flightmanagementsystem.model.ticket.TicketRequest;
import com.example.loconav.flightmanagementsystem.model.ticket.TicketResponse;

public interface ITicketService {
    public TicketResponse bookTicket(TicketRequest ticketRequest);
}
