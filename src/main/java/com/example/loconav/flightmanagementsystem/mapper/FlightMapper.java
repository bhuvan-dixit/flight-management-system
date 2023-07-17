package com.example.loconav.flightmanagementsystem.mapper;

import com.example.loconav.flightmanagementsystem.entity.Flight;
import com.example.loconav.flightmanagementsystem.entity.Ticket;
import com.example.loconav.flightmanagementsystem.model.flight.FlightInsertRequest;
import com.example.loconav.flightmanagementsystem.model.flight.FlightResponse;
import com.example.loconav.flightmanagementsystem.model.ticket.TicketRequest;
import com.example.loconav.flightmanagementsystem.repo.IFlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FlightMapper {
    @Autowired
    private IFlightRepo flightRepo;
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

    public Ticket TicketRequestToTicket(TicketRequest ticketRequest) {
        return Ticket.builder().ticketNumber(ticketRequest.getTicketNumber())
                .userAge(ticketRequest.getUserAge())
                .userName(ticketRequest.getUserName())
                .userGender(ticketRequest.getUserGender())
                .flight(flightRepo.getFlightById(ticketRequest.getFlightId())).build();
    }
}
