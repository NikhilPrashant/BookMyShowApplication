package com.nikhilprashant.book_my_show_app.Repository;

import com.nikhilprashant.book_my_show_app.Entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
