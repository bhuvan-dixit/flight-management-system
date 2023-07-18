package com.example.loconav.flight.management.system.controller;

import com.example.loconav.flight.management.system.model.ticket.TicketRequest;
import com.example.loconav.flight.management.system.model.ticket.TicketResponse;
import com.example.loconav.flight.management.system.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private ITicketService ticketService;

    @PostMapping("/")
    private TicketResponse bookTicket(@RequestBody final TicketRequest ticketRequest) {
        return ticketService.createTicket(ticketRequest);
    }
}
