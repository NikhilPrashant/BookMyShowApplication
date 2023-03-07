package com.nikhilprashant.book_my_show_app.Repository;

import com.nikhilprashant.book_my_show_app.Entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {

    @Query
    List<TicketEntity> findTicketEntitiesByUserEntityId(int userId);

    @Query(value = "select sum(total_amount) from tickets where movie_name = :movieName", nativeQuery = true)
    Integer getTotalRevenueByMovie(@Param("movieName") String movieName);
}
