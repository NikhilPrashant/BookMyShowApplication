package com.nikhilprashant.book_my_show_app.Converters;

import com.nikhilprashant.book_my_show_app.Entities.MovieEntity;
import com.nikhilprashant.book_my_show_app.EntryDTOs.MovieEntryDto;

public class MovieConverters {
    public static MovieEntity convertMovieDtoToEntity(MovieEntryDto movieEntryDto) {
        MovieEntity movieEntity = MovieEntity.builder()
                .movieName(movieEntryDto.getMovieName())
                .ratings(movieEntryDto.getRatings())
                .duration(movieEntryDto.getDuration())
                .language(movieEntryDto.getLanguage())
                .genre(movieEntryDto.getGenre())
                .build();
        return movieEntity;
    }
}
