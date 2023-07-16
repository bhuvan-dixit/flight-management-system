package com.example.loconav.flightmanagementsystem.controller;


import com.example.loconav.flightmanagementsystem.model.FlightInsertRequest;
import com.example.loconav.flightmanagementsystem.model.FlightResponse;
import com.example.loconav.flightmanagementsystem.model.TicketRequest;
import com.example.loconav.flightmanagementsystem.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
    @Autowired
    private IFlightService flightService;

    @GetMapping("/flights")
    private List<FlightResponse> getFlights() {
        return flightService.getFlights();
    }

    @PostMapping("/createFlight")
    private void insertFlight(@RequestBody final FlightInsertRequest flightRequest) {
        flightService.insertFlight(flightRequest);
    }

//    @PostMapping("bookTicket")
//    private TicketResponse bookTicket(@RequestBody final TicketRequest ticketRequest) {
//
//    }

}
