package com.nikhilprashant.book_my_show_app.Converters;

import com.nikhilprashant.book_my_show_app.Entities.TheatreEntity;
import com.nikhilprashant.book_my_show_app.EntryDTOs.TheatreEntryDto;

public class TheatreConverters {
    public static TheatreEntity convertTheatreDtoToEntity(TheatreEntryDto theatreEntryDto) {
        TheatreEntity theatreEntity = TheatreEntity.builder()
                .name(theatreEntryDto.getName())
                .location(theatreEntryDto.getLocation())
                .build();
        return theatreEntity;
    }
}
