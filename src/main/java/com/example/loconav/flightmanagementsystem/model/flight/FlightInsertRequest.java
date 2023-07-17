package com.example.loconav.flightmanagementsystem.model.flight;

import com.example.loconav.flightmanagementsystem.enums.FlightType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FlightInsertRequest {
    private Long flightNumber;

    private String origin;

    private String destination;

    private FlightType flightType;

    private Long departureTime;

    private Long expectedArrivalTime;

    private Integer numberOfSeats;
}
