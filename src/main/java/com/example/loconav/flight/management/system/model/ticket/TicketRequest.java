package com.example.loconav.flight.management.system.model.ticket;

import com.example.loconav.flight.management.system.constants.TicketConstant;
import com.example.loconav.flight.management.system.enums.Gender;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TicketRequest {

    @NotNull(message = TicketConstant.TICKET_NUMBER_MANDATORY)
    @Min(value = 0)
    private Integer ticketNumber;

    @NotBlank(message = TicketConstant.USER_NAME_NOT_BLANK)
    private String userName;

    @NotNull(message = TicketConstant.USER_AGE_MANDATORY)
    @Min(value = 0)
    private Integer userAge;

    @NotNull(message = TicketConstant.USER_GENDER_MANDATORY)
    private Gender userGender;

    @NotNull(message = TicketConstant.FLIGHT_ID_MANDATORY)
    private Integer flightId;
}
