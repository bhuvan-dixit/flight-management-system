package com.example.loconav.flightmanagementsystem.repo;

import com.example.loconav.flightmanagementsystem.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketRepo extends JpaRepository<Ticket, Integer> {

}
