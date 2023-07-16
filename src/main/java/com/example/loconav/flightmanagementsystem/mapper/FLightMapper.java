package com.example.loconav.flightmanagementsystem.mapper;

import com.example.loconav.flightmanagementsystem.entity.Flight;
import com.example.loconav.flightmanagementsystem.entity.Ticket;
import com.example.loconav.flightmanagementsystem.model.FlightInsertRequest;
import com.example.loconav.flightmanagementsystem.model.FlightResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FLightMapper {
    public Flight flightInsertRequestToFlight(FlightInsertRequest flightInsertRequest) {
        return Flight.builder().flightNumber(flightInsertRequest.getFlightNumber())
                .departureTime(flightInsertRequest.getDepartureTime())
                .destination(flightInsertRequest.getDestination())
                .flightType(flightInsertRequest.getFlightType())
                .origin(flightInsertRequest.getOrigin())
                .expectedArrivalTime(flightInsertRequest.getExpectedArrivalTime())
                .numberOfBookedSeats(0)
                .numberOfSeats(flightInsertRequest.getNumberOfSeats()).tickets(new ArrayList<Ticket>()).build();
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
