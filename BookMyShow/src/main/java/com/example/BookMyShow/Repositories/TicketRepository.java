package com.example.BookMyShow.Repositories;

import com.example.BookMyShow.Modals.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
