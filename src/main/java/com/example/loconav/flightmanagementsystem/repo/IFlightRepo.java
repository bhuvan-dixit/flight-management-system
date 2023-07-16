package com.example.loconav.flightmanagementsystem.repo;

import com.example.loconav.flightmanagementsystem.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFlightRepo extends JpaRepository<Flight, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM flights")
    List<Flight> getFlights();
}
