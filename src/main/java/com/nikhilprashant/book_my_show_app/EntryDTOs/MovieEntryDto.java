package com.nikhilprashant.book_my_show_app.EntryDTOs;

import com.nikhilprashant.book_my_show_app.Enums.Genre;
import com.nikhilprashant.book_my_show_app.Enums.Language;
import lombok.Data;

@Data
public class MovieEntryDto {
    private String movieName;
    private double ratings;
    private int duration;
    private Language language;
    private Genre genre;
}
