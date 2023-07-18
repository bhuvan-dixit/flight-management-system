package com.example.loconav.flight.management.system.service.impl;

import com.example.loconav.flight.management.system.entity.Flight;
import com.example.loconav.flight.management.system.mapper.FlightMapper;
import com.example.loconav.flight.management.system.model.flight.FilterFlightRequest;
import com.example.loconav.flight.management.system.model.flight.FlightCreateRequest;
import com.example.loconav.flight.management.system.model.flight.FlightResponse;
import com.example.loconav.flight.management.system.repo.IFlightRepo;
import com.example.loconav.flight.management.system.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService implements IFlightService {
    @Autowired
    private FlightMapper fLightMapper;

    @Autowired
    private IFlightRepo flightRepo;

    /***
     *
     * @param flightCreateRequest
     */
    public void createFlight(final FlightCreateRequest flightCreateRequest) {
        flightRepo.save(fLightMapper.flightInsertRequestToFlight(flightCreateRequest));
    }

    /***
     *
     * @return
     */
    public List<FlightResponse> fetchFlights() {
        return flightRepo.fetchFlights().stream().map(flight -> fLightMapper.flightToFlightResponse(flight)).collect(Collectors.toList());
    }

    /***
     *
     * @param id
     * @return
     */
    @Override
    public FlightResponse fetchFlight(final Integer id) {
        return fLightMapper.flightToFlightResponse(flightRepo.fetchFlight(id));
    }

    /***
     *
     * @param flightId
     * @return
     */
    @Override
    public Integer fetchAvailableSeats(final Integer flightId) {
        return flightRepo.fetchAvailableSeats(flightId);
    }

    /***
     *
     * @param filterFlightRequest
     * @return
     */
    @Override
    public List<FlightResponse> fetchFlightsWithFilter(final FilterFlightRequest filterFlightRequest) {
        System.out.println(filterFlightRequest);
        Long currentTime = null;
        if(filterFlightRequest.getFutureFlight() != null) {
            currentTime = Instant.now().getEpochSecond();
        }
        List<Flight> flight = flightRepo.fetchFlightsWithFilter(filterFlightRequest.getId(),
                filterFlightRequest.getFlightNumber(),
                filterFlightRequest.getOrigin(),
                filterFlightRequest.getDestination(),
                currentTime);
        return flight.stream().map(flightEntry -> fLightMapper.flightToFlightResponse(flightEntry)).collect(Collectors.toList());
    }

}
