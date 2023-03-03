package com.nikhilprashant.book_my_show_app.Repository;

import com.nikhilprashant.book_my_show_app.Entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
}
