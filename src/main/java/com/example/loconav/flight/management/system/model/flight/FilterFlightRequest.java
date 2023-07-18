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
public class FilterFlightRequest {

    private Integer flightNumber;

    private Integer id;

    private String origin;

//    @NotBlank
    private String destination;

    private FlightType flightType;

    private Boolean futureFlight;
}
