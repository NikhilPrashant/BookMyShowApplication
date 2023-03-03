package com.nikhilprashant.book_my_show_app.EntryDTOs;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketEntryDto {

    private int userId;
    private int showId;
    private List<String> requestedSeats = new ArrayList<>();
}
