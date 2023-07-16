package com.example.loconav.flightmanagementsystem.entity;

import com.example.loconav.flightmanagementsystem.enums.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Audited
@Entity
@Table(name = "tickets")
public class Ticket extends AbstractEntity {

    @Column(name = "ticket_number")
    private Integer ticketNumber;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_age")
    private Integer userAge;

    @Column(name = "user_gender")
    private Gender userGender;

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @PrePersist
    private void onCreate() {
        this.flight.setNumberOfBookedSeats(flight.getNumberOfBookedSeats()+1);
        this.flight.getTickets().add(this);
    }

}
