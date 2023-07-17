package com.example.loconav.flightmanagementsystem.controller;


import com.example.loconav.flightmanagementsystem.model.flight.FilterFlightRequest;
import com.example.loconav.flightmanagementsystem.model.flight.FlightInsertRequest;
import com.example.loconav.flightmanagementsystem.model.flight.FlightResponse;
import com.example.loconav.flightmanagementsystem.model.ticket.TicketRequest;
import com.example.loconav.flightmanagementsystem.model.ticket.TicketResponse;
import com.example.loconav.flightmanagementsystem.service.IFlightService;
import com.example.loconav.flightmanagementsystem.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
    @Autowired
    private IFlightService flightService;
    @Autowired
    private ITicketService ticketService;

    @GetMapping("/flights")
    private List<FlightResponse> getFlights() {
        return flightService.getFlights();
    }

    @GetMapping("/flight")
    public FlightResponse getFlightById(@RequestParam final Integer id) {
        return flightService.getFlightById(id);
    }

    @PostMapping("/createFlight")
    private void insertFlight(@RequestBody final FlightInsertRequest flightRequest) {
        flightService.insertFlight(flightRequest);
    }

    @GetMapping("/availableSeats")
    public Integer getAvailableSeats(@RequestParam final Integer flightId) {
        return flightService.getAvailableSeats(flightId);
    }

    @PostMapping("/bookTicket")
    private TicketResponse bookTicket(@RequestBody final TicketRequest ticketRequest) {
        return ticketService.bookTicket(ticketRequest);
    }

    @GetMapping("/filter")
    private FlightResponse getFlightsWithFilter(FilterFlightRequest fIlterFlightRequest) {
        return flightService.getFlightsWithFilter(fIlterFlightRequest);
    }

}
