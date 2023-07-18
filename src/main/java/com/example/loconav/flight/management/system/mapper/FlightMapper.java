package com.example.loconav.flight.management.system.mapper;

import com.example.loconav.flight.management.system.model.flight.FlightCreateRequest;
import com.example.loconav.flight.management.system.entity.Flight;
import com.example.loconav.flight.management.system.entity.Ticket;
import com.example.loconav.flight.management.system.model.flight.FlightResponse;
import com.example.loconav.flight.management.system.repo.IFlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FlightMapper {

    @Autowired
    private IFlightRepo flightRepo;

    public Flight flightInsertRequestToFlight(FlightCreateRequest flightCreateRequest) {
        return Flight.builder().flightNumber(flightCreateRequest.getFlightNumber())
                .departureTime(flightCreateRequest.getExpectedDepartureTime())
                .destination(flightCreateRequest.getDestination())
                .flightType(flightCreateRequest.getFlightType())
                .origin(flightCreateRequest.getOrigin())
                .expectedArrivalTime(flightCreateRequest.getExpectedArrivalTime())
                .numberOfBookedSeats(0)
                .numberOfSeats(flightCreateRequest.getNumberOfSeats()).tickets(new ArrayList<Ticket>()).build();
    }

    public FlightResponse flightToFlightResponse(Flight flight) {
        return FlightResponse.builder().flightNumber(flight.getFlightNumber())
                .flightType(flight.getFlightType())
                .origin(flight.getOrigin())
                .departureTime(flight.getDepartureTime())
                .destination(flight.getDestination())
                .numberOfVacantSeats(flight.getNumberOfSeats() - flight.getNumberOfBookedSeats())
                .expectedArrivalTime(flight.getExpectedArrivalTime())
                .build();
    }

}
