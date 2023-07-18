package com.example.loconav.flight.management.system.entity;

import com.example.loconav.flight.management.system.enums.Gender;
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

}
