package com.example.loconav.flight.management.system.service;

import com.example.loconav.flight.management.system.entity.Flight;
import com.example.loconav.flight.management.system.model.flight.FilterFlightRequest;
import com.example.loconav.flight.management.system.model.flight.FlightCreateRequest;
import com.example.loconav.flight.management.system.model.flight.FlightResponse;

import java.util.List;

public interface IFlightService {
    public void createFlight(FlightCreateRequest flightCreateRequest);

    public List<FlightResponse> fetchFlights();

    FlightResponse fetchFlight(Integer id);

    Integer fetchAvailableSeats(Integer flightId);

    List<FlightResponse> fetchFlightsWithFilter(FilterFlightRequest fIlterFlightRequest);
}
