package com.example.loconav.flight.management.system.model.flight;

import com.example.loconav.flight.management.system.constants.FlightConstant;
import com.example.loconav.flight.management.system.enums.FlightType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FlightCreateRequest {

    @NotNull(message = FlightConstant.FLIGHT_NUMBER_MANDATORY)
    @Min(value = 0)
    private Long flightNumber;

    @NotBlank(message = FlightConstant.ORIGIN_SHOULD_NOT_BE_BLANK)
    private String origin;

    @NotBlank(message = FlightConstant.DESTINATION_SHOULD_NOT_BE_BLANK)
    private String destination;

    private FlightType flightType;

    @NotNull(message = FlightConstant.EXPECTED_DEPARTURE_TIME_MANDATORY)
    @Min(value = 0)
    private Long expectedDepartureTime;

    @Min(value = 0)
    @NotNull(message = FlightConstant.EXPECTED_ARRIVAL_TIME_MANDATORY)
    private Long expectedArrivalTime;

    @Min(value = 0)
    @NotNull(message = FlightConstant.NUMBER_OF_SEATS_MANDATORY)
    @Max(value = 250)
    private Integer numberOfSeats;
}
