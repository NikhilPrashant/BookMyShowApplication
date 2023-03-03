package com.nikhilprashant.book_my_show_app.Converters;

import com.nikhilprashant.book_my_show_app.Entities.ShowEntity;
import com.nikhilprashant.book_my_show_app.EntryDTOs.ShowEntryDto;
import lombok.Data;

@Data
public class ShowConverters {
    public static ShowEntity convertShowDtoToEntity(ShowEntryDto showEntryDto) {
        ShowEntity showEntity = ShowEntity.builder()
                .showDate(showEntryDto.getLocalDate())
                .showTime(showEntryDto.getLocalTime())
                .showType(showEntryDto.getShowType())
                .build();
        return showEntity;
    }
}
