package com.example.loconav.flightmanagementsystem.model;

import com.example.loconav.flightmanagementsystem.entity.Flight;
import com.example.loconav.flightmanagementsystem.enums.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class TicketRequest {
    private Integer ticketNumber;

    private String userName;

    private Integer userAge;

    private Gender userGender;

    private Flight flight;
}
