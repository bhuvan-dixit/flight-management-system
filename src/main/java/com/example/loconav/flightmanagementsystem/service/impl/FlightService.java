package com.example.loconav.flightmanagementsystem.service.impl;

import com.example.loconav.flightmanagementsystem.mapper.FlightMapper;
import com.example.loconav.flightmanagementsystem.model.flight.FilterFlightRequest;
import com.example.loconav.flightmanagementsystem.model.flight.FlightInsertRequest;
import com.example.loconav.flightmanagementsystem.model.flight.FlightResponse;
import com.example.loconav.flightmanagementsystem.repo.IFlightRepo;
import com.example.loconav.flightmanagementsystem.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService implements IFlightService {
    @Autowired
    private FlightMapper fLightMapper;
    @Autowired
    private IFlightRepo flightRepo;

    public void insertFlight(FlightInsertRequest flightInsertRequest) {
        flightRepo.save(fLightMapper.flightInsertRequestToFlight(flightInsertRequest));
    }

    public List<FlightResponse> getFlights() {
        return flightRepo.getFlights().stream().map(flight -> fLightMapper.flightToFlightResponse(flight)).collect(Collectors.toList());
    }

    @Override
    public FlightResponse getFlightById(final Integer id) {
        return fLightMapper.flightToFlightResponse(flightRepo.getFlightById(id));
    }

    @Override
    public Integer getAvailableSeats(final Integer flightId) {
        return flightRepo.getAvailableSeats(flightId);
    }

    @Override
    public FlightResponse getFlightsWithFilter(FilterFlightRequest filterFlightRequest) {
        return fLightMapper.flightToFlightResponse(flightRepo.getFlightsWithFilter(filterFlightRequest.getId(),
                filterFlightRequest.getFlightNumber(),
                filterFlightRequest.getOrigin(),
                filterFlightRequest.getDestination(),
                filterFlightRequest.getFlightType(),
                filterFlightRequest.getFutureFlight()));
    }


}
