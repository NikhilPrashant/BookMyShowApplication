package com.nikhilprashant.book_my_show_app.Repository;

import com.nikhilprashant.book_my_show_app.Entities.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TheatreRepository extends JpaRepository<TheatreEntity, Integer> {

    //Native
    @Query(value = "SELECT COUNT(DISTINCT location) FROM theatres;",
            nativeQuery = true)
    Integer countOfUniqueLocations();
}
