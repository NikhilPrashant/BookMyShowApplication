package com.nikhilprashant.book_my_show_app.EntryDTOs;

import lombok.Data;

@Data
public class TheatreEntryDto {

    private String name;
    private String location;
    private int numberOfClassicSeats;
    private int numberOfPremiumSeats;
}
