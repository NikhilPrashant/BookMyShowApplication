package com.nikhilprashant.book_my_show_app.Service;

import com.nikhilprashant.book_my_show_app.Converters.ShowConverters;
import com.nikhilprashant.book_my_show_app.Entities.*;
import com.nikhilprashant.book_my_show_app.EntryDTOs.ShowEntryDto;
import com.nikhilprashant.book_my_show_app.Enums.SeatType;
import com.nikhilprashant.book_my_show_app.Repository.MovieRepository;
import com.nikhilprashant.book_my_show_app.Repository.ShowRepository;
import com.nikhilprashant.book_my_show_app.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    public String addShow(ShowEntryDto showEntryDto) throws Exception {
        ShowEntity showEntity = ShowConverters.convertShowDtoToEntity(showEntryDto);
        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieId()).get();
        TheatreEntity theatreEntity = theatreRepository.findById(showEntryDto.getTheatreId()).get();
        List<ShowSeatEntity> showSeatEntityList = createShowSeatEntityList(showEntryDto, showEntity, theatreEntity, movieEntity);
        showEntity.setListOfShowSeats(showSeatEntityList);
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheatreEntity(theatreEntity);
        showEntity = showRepository.save(showEntity);
        movieEntity.getShowEntityList().add(showEntity);
        theatreEntity.getShowEntityList().add(showEntity);
        movieRepository.save(movieEntity);
        theatreRepository.save(theatreEntity);
        return "Show added successfully";
    }

    private List<ShowSeatEntity> createShowSeatEntityList(ShowEntryDto showEntryDto, ShowEntity showEntity, TheatreEntity theatreEntity, MovieEntity movieEntity) {
        List<ShowSeatEntity> showSeatEntityList = new ArrayList<>();
        List<TheatreSeatEntity> theatreSeatEntityList = theatreEntity.getTheatreSeatEntityList();
        for (TheatreSeatEntity theatreSeatEntity: theatreSeatEntityList) {
            ShowSeatEntity showSeatEntity = ShowSeatEntity.builder()
                    .seatNo(theatreSeatEntity.getSeatNo())
                    .price(theatreSeatEntity.getSeatType() == SeatType.CLASSIC? showEntryDto.getClassicSeatPrice(): showEntryDto.getPremiumSeatPrice())
                    .seatType(theatreSeatEntity.getSeatType())
                    .showEntity(showEntity)
                    .build();
            showSeatEntityList.add(showSeatEntity);
        }
        return showSeatEntityList;
    }
}
