package com.example.loconav.flight.management.system.controller;


import com.example.loconav.flight.management.system.enums.FlightType;
import com.example.loconav.flight.management.system.model.flight.FilterFlightRequest;
import com.example.loconav.flight.management.system.model.flight.FlightCreateRequest;
import com.example.loconav.flight.management.system.model.flight.FlightResponse;
import com.example.loconav.flight.management.system.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private IFlightService flightService;

    @PostMapping("")
    private void createFlight(@Valid @RequestBody final FlightCreateRequest flightRequest) {
        flightService.createFlight(flightRequest);
    }

    @GetMapping("/details")
    public FlightResponse fetchFlight(@RequestParam final Integer id) {
        return flightService.fetchFlight(id);
    }

    @GetMapping("/availableSeats")
    public Integer fetchAvailableSeats(@RequestParam final Integer flightId) {
        return flightService.fetchAvailableSeats(flightId);
    }

    @GetMapping("/filter")
    private List<FlightResponse> fetchFlightsWithFilter(@RequestParam(required = false) Integer flightNumber,
                                                  @RequestParam(required = false) Integer id,
                                                  @RequestParam(required = false) String origin,
                                                  @RequestParam(required = false) String destination,
                                                  @RequestParam(required = false) FlightType flightType,
                                                  @RequestParam(required = false) Boolean futureFlight) {
        FilterFlightRequest filterFlightRequest = FilterFlightRequest.builder()
                .id(id)
                .flightNumber(flightNumber)
                .futureFlight(futureFlight)
                .origin(origin)
                .destination(destination)
                .flightType(flightType).build();
        return flightService.fetchFlightsWithFilter(filterFlightRequest);
    }

    @GetMapping("")
    private List<FlightResponse> fetchFlights() {
        return flightService.fetchFlights();
    }
}
