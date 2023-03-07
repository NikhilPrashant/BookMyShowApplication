package com.nikhilprashant.book_my_show_app.Repository;

import com.nikhilprashant.book_my_show_app.Entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

    @Query(value = "SELECT movie_entity_id FROM shows GROUP BY movie_entity_id ORDER BY COUNT(*) DESC, movie_entity_id ASC LIMIT 1;",
    nativeQuery = true)
    Integer getMovieWithMaxShows();
}
