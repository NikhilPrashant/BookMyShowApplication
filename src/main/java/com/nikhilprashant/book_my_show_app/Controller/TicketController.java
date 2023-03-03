package com.nikhilprashant.book_my_show_app.Controller;

import com.nikhilprashant.book_my_show_app.EntryDTOs.TicketEntryDto;
import com.nikhilprashant.book_my_show_app.Repository.TicketRepository;
import com.nikhilprashant.book_my_show_app.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/add")
    public ResponseEntity<String> addTicket(@RequestBody TicketEntryDto ticketEntryDto) {
        try {
            String response = ticketService.addTicket(ticketEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
