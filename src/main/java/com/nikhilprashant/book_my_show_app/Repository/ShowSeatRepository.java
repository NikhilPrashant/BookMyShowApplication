package com.nikhilprashant.book_my_show_app.Repository;

import com.nikhilprashant.book_my_show_app.Entities.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeatEntity, Integer> {
}
