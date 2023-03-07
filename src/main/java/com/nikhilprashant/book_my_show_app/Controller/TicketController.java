package com.nikhilprashant.book_my_show_app.Controller;

import com.nikhilprashant.book_my_show_app.Entities.TicketEntity;
import com.nikhilprashant.book_my_show_app.EntryDTOs.TicketEntryDto;
import com.nikhilprashant.book_my_show_app.Repository.TicketRepository;
import com.nikhilprashant.book_my_show_app.Service.TicketService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getTicketBookedBy/{userId}")
    public ResponseEntity<List<TicketEntity>> getTicketBookedBy(@PathVariable Integer userId) {
        List<TicketEntity> response = ticketService.getTicketBookedBy(userId);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<String> cancelTicket(@RequestParam Integer ticketId) {
        String response = ticketService.cancelTicket(ticketId);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
