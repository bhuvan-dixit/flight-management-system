package com.example.loconav.flightmanagementsystem.service;

import com.example.loconav.flightmanagementsystem.model.flight.FilterFlightRequest;
import com.example.loconav.flightmanagementsystem.model.flight.FlightInsertRequest;
import com.example.loconav.flightmanagementsystem.model.flight.FlightResponse;

import java.util.List;

public interface IFlightService {
    public void insertFlight(FlightInsertRequest flightInsertRequest);

    public List<FlightResponse> getFlights();

    FlightResponse getFlightById(Integer id);

    Integer getAvailableSeats(Integer flightId);

    FlightResponse getFlightsWithFilter(FilterFlightRequest fIlterFlightRequest);
}
