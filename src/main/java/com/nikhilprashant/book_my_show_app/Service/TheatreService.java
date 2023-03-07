package com.nikhilprashant.book_my_show_app.Service;

import com.nikhilprashant.book_my_show_app.Converters.TheatreConverters;
import com.nikhilprashant.book_my_show_app.Entities.TheatreEntity;
import com.nikhilprashant.book_my_show_app.Entities.TheatreSeatEntity;
import com.nikhilprashant.book_my_show_app.EntryDTOs.TheatreEntryDto;
import com.nikhilprashant.book_my_show_app.Enums.SeatType;
import com.nikhilprashant.book_my_show_app.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    public String addMovie(TheatreEntryDto theatreEntryDto) throws Exception {
        if (theatreEntryDto.getName() == null || theatreEntryDto.getLocation() == null) {
            throw new Exception("Name and Theatre should be valid");
        }
        TheatreEntity theatreEntity = TheatreConverters.convertTheatreDtoToEntity(theatreEntryDto);
        List<TheatreSeatEntity> theatreSeatEntityList = createTheatreSeatList(theatreEntryDto, theatreEntity);
        theatreEntity.setTheatreSeatEntityList(theatreSeatEntityList);
        theatreRepository.save(theatreEntity);
        return "Theatre added successfully";
    }

    private List<TheatreSeatEntity> createTheatreSeatList(TheatreEntryDto theatreEntryDto, TheatreEntity theatreEntity) {
        List<TheatreSeatEntity> theatreSeatEntityList = new ArrayList<>();
        int numberOfClassicSeats = theatreEntryDto.getNumberOfClassicSeats();
        int numberOfPremiumSeats = theatreEntryDto.getNumberOfPremiumSeats();
        for (int count = 1; count <= numberOfClassicSeats; count++) {
            theatreSeatEntityList.add(TheatreSeatEntity.builder()
                    .seatType(SeatType.CLASSIC)
                    .seatNo(count + "C")
                    .theatreEntity(theatreEntity)
                    .build());
        }
        for (int count = 1; count <= numberOfPremiumSeats; count++) {
            theatreSeatEntityList.add(TheatreSeatEntity.builder()
                    .seatType(SeatType.PREMIUM)
                    .seatNo(count + "P")
                    .theatreEntity(theatreEntity)
                    .build());
        }
        return theatreSeatEntityList;
    }

    public Integer getCountOfDistinctLocations() {
        return theatreRepository.countOfUniqueLocations();
    }
}
