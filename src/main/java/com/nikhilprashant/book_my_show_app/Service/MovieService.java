package com.nikhilprashant.book_my_show_app.Service;

import com.nikhilprashant.book_my_show_app.Converters.MovieConverters;
import com.nikhilprashant.book_my_show_app.Entities.MovieEntity;
import com.nikhilprashant.book_my_show_app.EntryDTOs.MovieEntryDto;
import com.nikhilprashant.book_my_show_app.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto) throws Exception {
        MovieEntity movieEntity = MovieConverters.convertMovieDtoToEntity(movieEntryDto);
        movieRepository.save(movieEntity);
        return "Movie Added Successfully";
    }
}
