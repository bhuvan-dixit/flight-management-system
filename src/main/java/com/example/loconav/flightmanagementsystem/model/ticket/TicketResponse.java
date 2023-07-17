package com.example.loconav.flightmanagementsystem.model.ticket;

import com.example.loconav.flightmanagementsystem.enums.FlightType;
import com.example.loconav.flightmanagementsystem.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TicketResponse {
//    private Integer ticketNumber;
//
//    private String userName;
//
//    private Integer userAge;
//
//    private Gender userGender;
//
//    private String source;
//
//    private String destination;
//
//    private FlightType flightType;
//
//    private Long departureTime;
//
//    private Long expectedArrivalTime;

    private String response;
}
