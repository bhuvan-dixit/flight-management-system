package com.example.loconav.flight.management.system.model.flight;

import com.example.loconav.flight.management.system.enums.FlightType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FlightResponse {
    private Long flightNumber;

    private String origin;

    private String destination;

    private FlightType flightType;

    private Long departureTime;

    private Long expectedArrivalTime;

    private Integer numberOfVacantSeats;
}
