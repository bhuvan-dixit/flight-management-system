package com.example.loconav.flightmanagementsystem.model.ticket;

import com.example.loconav.flightmanagementsystem.entity.Flight;
import com.example.loconav.flightmanagementsystem.enums.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TicketRequest {
    private Integer ticketNumber;

    private String userName;

    private Integer userAge;

    private Gender userGender;

    private Integer flightId;
}
