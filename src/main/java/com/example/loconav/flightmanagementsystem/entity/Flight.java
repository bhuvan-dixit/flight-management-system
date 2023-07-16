package com.example.loconav.flightmanagementsystem.entity;

import com.example.loconav.flightmanagementsystem.enums.FlightType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

//flight number, origin, destination, flight type(international or domestic), departure time,
//        expected arrival time, number of seats, number of booked seats
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Audited
@Table(name = "flights")
@Entity
public class Flight extends AbstractEntity {
    @Column(name = "flight_number")
    private Long flightNumber;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Enumerated(EnumType.STRING)
    @Column(name = "flight_type")
    private FlightType flightType;

    @Column(name = "departure_time")
    private Long departureTime;

    @Column(name =  "expected_arrival_time")
    private Long expectedArrivalTime;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

    @Column(name = "number_of_booked_seats")
    private Integer numberOfBookedSeats;

    @JsonManagedReference
    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets;
}
