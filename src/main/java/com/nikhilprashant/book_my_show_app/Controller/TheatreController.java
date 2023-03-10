package com.nikhilprashant.book_my_show_app.Controller;

import com.nikhilprashant.book_my_show_app.EntryDTOs.TheatreEntryDto;
import com.nikhilprashant.book_my_show_app.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/add")
    public ResponseEntity<String> addTheatre(@RequestBody TheatreEntryDto theatreEntryDto) {
        try {
            String response = theatreService.addMovie(theatreEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getCountOfDistinctLocations")
    private ResponseEntity<Integer> getCountOfDistinctLocations() {
        Integer response = theatreService.getCountOfDistinctLocations();
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
}
