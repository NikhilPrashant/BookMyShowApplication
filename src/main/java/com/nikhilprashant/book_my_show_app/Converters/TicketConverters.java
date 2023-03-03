package com.nikhilprashant.book_my_show_app.Converters;

import com.nikhilprashant.book_my_show_app.Entities.TicketEntity;
import com.nikhilprashant.book_my_show_app.EntryDTOs.TicketEntryDto;

public class TicketConverters {
    public static TicketEntity convertTicketDtoToEntity(TicketEntryDto ticketEntryDto) {
        TicketEntity ticketEntity = new TicketEntity();
        return ticketEntity;
    }
}
