package com.example.loconav.flightmanagementsystem.service;

import com.example.loconav.flightmanagementsystem.model.FlightInsertRequest;
import com.example.loconav.flightmanagementsystem.model.FlightResponse;

import java.util.List;

public interface IFlightService {
    public void insertFlight(FlightInsertRequest flightInsertRequest);

    public List<FlightResponse> getFlights();
}
