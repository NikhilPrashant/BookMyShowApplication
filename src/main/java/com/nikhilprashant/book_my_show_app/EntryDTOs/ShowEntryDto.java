package com.nikhilprashant.book_my_show_app.EntryDTOs;

import com.nikhilprashant.book_my_show_app.Enums.ShowType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntryDto {

    private LocalDate localDate;
    private LocalTime localTime;
    private ShowType showType;
    private int movieId;
    private int theatreId;
    private int classicSeatPrice;
    private int premiumSeatPrice;
}
