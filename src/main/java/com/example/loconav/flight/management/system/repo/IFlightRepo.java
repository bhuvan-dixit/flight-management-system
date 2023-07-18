package com.example.loconav.flight.management.system.repo;

import com.example.loconav.flight.management.system.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFlightRepo extends JpaRepository<Flight, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM flights")
    List<Flight> fetchFlights();

    @Query(nativeQuery = true, value = "SELECT * FROM flights where id = :id")
    Flight fetchFlight(Integer id);

    @Query(nativeQuery = true, value = "SELECT (number_of_seats - number_of_booked_seats) as no_of_available_seats " +
            "FROM flights where id = :flightId")
    Integer fetchAvailableSeats(Integer flightId);

    @Query(nativeQuery = true, value = "SELECT * FROM flights where " +
            "(:id is NULL OR id  = :id) AND " +
            "(:flightNumber is NULL OR flight_number = :flightNumber) AND " +
            "(:origin is NULL OR origin = :origin) AND " +
            "(:destination is NULL OR destination = :destination) AND " +
            "(:futureFlight is NULL OR departure_time > :futureFlight)")
    List<Flight> fetchFlightsWithFilter(Integer id, Integer flightNumber, String origin, String destination, Long futureFlight);

}
