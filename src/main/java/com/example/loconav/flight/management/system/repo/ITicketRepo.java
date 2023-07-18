package com.example.loconav.flight.management.system.repo;

import com.example.loconav.flight.management.system.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketRepo extends JpaRepository<Ticket, Integer> {

}
