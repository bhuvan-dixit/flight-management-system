package com.example.loconav.flightmanagementsystem.service.impl;

import com.example.loconav.flightmanagementsystem.entity.Flight;
import com.example.loconav.flightmanagementsystem.mapper.FLightMapper;
import com.example.loconav.flightmanagementsystem.model.FlightInsertRequest;
import com.example.loconav.flightmanagementsystem.model.FlightResponse;
import com.example.loconav.flightmanagementsystem.repo.IFlightRepo;
import com.example.loconav.flightmanagementsystem.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService implements IFlightService {
    @Autowired
    private FLightMapper fLightMapper;
    @Autowired
    private IFlightRepo flightRepo;
    public void insertFlight(FlightInsertRequest flightInsertRequest) {
        flightRepo.save(fLightMapper.flightInsertRequestToFlight(flightInsertRequest));
    }

    public List<FlightResponse> getFlights() {
        return flightRepo.getFlights().stream().map(flight -> fLightMapper.flightToFlightResponse(flight)).collect(Collectors.toList());
    }
}
