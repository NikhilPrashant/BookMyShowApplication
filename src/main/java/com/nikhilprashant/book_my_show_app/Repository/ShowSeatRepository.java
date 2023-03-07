package com.nikhilprashant.book_my_show_app.Repository;

import com.nikhilprashant.book_my_show_app.Entities.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShowSeatRepository extends JpaRepository<ShowSeatEntity, Integer> {

    @Query(value = "select id from show_seats where seat_no = :seatNo and show_entity_id = :showEntityId",
            nativeQuery = true)
    int findIdBySeatNo(@Param("seatNo") String seatNo, @Param("showEntityId") int showEntityId);
}
