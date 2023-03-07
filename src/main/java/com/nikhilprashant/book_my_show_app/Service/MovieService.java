package com.nikhilprashant.book_my_show_app.Service;

import com.nikhilprashant.book_my_show_app.Converters.MovieConverters;
import com.nikhilprashant.book_my_show_app.Entities.MovieEntity;
import com.nikhilprashant.book_my_show_app.EntryDTOs.MovieEntryDto;
import com.nikhilprashant.book_my_show_app.Repository.MovieRepository;
import com.nikhilprashant.book_my_show_app.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TicketRepository ticketRepository;

    public String addMovie(MovieEntryDto movieEntryDto) throws Exception {
        MovieEntity movieEntity = MovieConverters.convertMovieDtoToEntity(movieEntryDto);
        movieRepository.save(movieEntity);
        return "Movie Added Successfully";
    }

    public String getMovieWithMaxShows() {
        int idWithMaxShows = movieRepository.getMovieWithMaxShows();
        MovieEntity movieEntity = movieRepository.findById(idWithMaxShows).get();
        return movieEntity.getMovieName().toString();
    }

    public Integer getTotalRevenueByMovie(Integer movieId) {
        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        String movieName = movieEntity.getMovieName();
        Integer collection = ticketRepository.getTotalRevenueByMovie(movieName);
        return collection;
    }
}
