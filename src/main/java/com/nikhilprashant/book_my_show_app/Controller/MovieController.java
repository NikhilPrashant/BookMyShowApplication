package com.nikhilprashant.book_my_show_app.Controller;

import com.nikhilprashant.book_my_show_app.EntryDTOs.MovieEntryDto;
import com.nikhilprashant.book_my_show_app.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody MovieEntryDto movieEntryDto) {
        try {
            String response = movieService.addMovie(movieEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getMovieWithMaxShows")
    public ResponseEntity<String> getMovieWithMaxShows() {
        String response = movieService.getMovieWithMaxShows();
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/getTotalRevenueByMovie")
    public ResponseEntity<Integer> getTotalRevenueByMovie(@RequestParam Integer movieId) {
        Integer response = movieService.getTotalRevenueByMovie(movieId);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
}
