package com.nikhilprashant.book_my_show_app.Repository;

import com.nikhilprashant.book_my_show_app.Entities.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreSeatRepository extends JpaRepository<TheatreSeatEntity, Integer> {
}
