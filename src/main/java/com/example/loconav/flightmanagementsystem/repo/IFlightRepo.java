package com.example.loconav.flightmanagementsystem.repo;

import com.example.loconav.flightmanagementsystem.entity.Flight;
import com.example.loconav.flightmanagementsystem.entity.Ticket;
import com.example.loconav.flightmanagementsystem.enums.FlightType;
import com.example.loconav.flightmanagementsystem.model.flight.FlightResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFlightRepo extends JpaRepository<Flight, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM flights")
    List<Flight> getFlights();

    @Query(nativeQuery = true, value = "SELECT * FROM flights where id = :id")
    Flight getFlightById(Integer id);
    @Query(nativeQuery = true, value = "SELECT (number_of_seats - number_of_booked_seats) as no_of_available_seats " +
            "FROM flights where id = :flightId")
    Integer getAvailableSeats(Integer flightId);
    @Query(nativeQuery = true, value = "SELECT * FROM flights where" +
            "(:id is NULL OR id  = :id) AND" +
            "(:flightNumber is NULL OR flight_number = :flightNumber) AND" +
            "(:origin is NULL OR origin = :origin) AND" +
            "(:destination is NULL OR destination = :destination) AND" +
            "(:flightType is NULL OR flight_type = :flightType)")
    Flight getFlightsWithFilter(Integer id, Integer flightNumber, String origin, String destination, FlightType flightType, Long futureFlight);
}
