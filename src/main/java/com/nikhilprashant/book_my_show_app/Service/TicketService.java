package com.nikhilprashant.book_my_show_app.Service;

import com.nikhilprashant.book_my_show_app.Converters.TicketConverters;
import com.nikhilprashant.book_my_show_app.Entities.ShowEntity;
import com.nikhilprashant.book_my_show_app.Entities.ShowSeatEntity;
import com.nikhilprashant.book_my_show_app.Entities.TicketEntity;
import com.nikhilprashant.book_my_show_app.Entities.UserEntity;
import com.nikhilprashant.book_my_show_app.EntryDTOs.TicketEntryDto;
import com.nikhilprashant.book_my_show_app.Repository.ShowRepository;
import com.nikhilprashant.book_my_show_app.Repository.ShowSeatRepository;
import com.nikhilprashant.book_my_show_app.Repository.TicketRepository;
import com.nikhilprashant.book_my_show_app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    public String addTicket(TicketEntryDto ticketEntryDto) throws Exception {
        TicketEntity ticketEntity = TicketConverters.convertTicketDtoToEntity(ticketEntryDto);
        boolean isValidRequest = checkValidityOfRequests(ticketEntryDto);
        if (!isValidRequest) throw new Exception("Requested seats are not available");
        ShowEntity showEntity = showRepository.findById(ticketEntryDto.getShowId()).get();
        List<ShowSeatEntity> showSeatEntityList = showEntity.getListOfShowSeats();
        List<String> seatsRequested = ticketEntryDto.getRequestedSeats();
        int amount = 0;
        for (ShowSeatEntity showSeatEntity: showSeatEntityList) {
            if (seatsRequested.contains(showSeatEntity.getSeatNo())) {
                amount += showSeatEntity.getPrice();
                showSeatEntity.setBooked(true);
                showSeatEntity.setBookedAt(new Date());
            }
        }
        ticketEntity.setTotalAmount(amount);
        ticketEntity.setMovieName(showEntity.getMovieEntity().getMovieName());
        ticketEntity.setShowTiming(showEntity.getShowTime());
        ticketEntity.setTheatreName(showEntity.getTheatreEntity().getName());

        String allocatedSeats = "";
        for (String s: seatsRequested) {
            allocatedSeats += s + ", ";
        }
        ticketEntity.setBookedSeats(allocatedSeats);

        UserEntity userEntity = userRepository.findById(ticketEntryDto.getUserId()).get();

        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setShowEntity(showEntity);

        ticketEntity = ticketRepository.save(ticketEntity);

        List<TicketEntity> ticketEntityList = showEntity.getListOfBookedSeats();
        ticketEntityList.add(ticketEntity);
        showEntity.setListOfBookedSeats(ticketEntityList);

        showRepository.save(showEntity);

        List<TicketEntity> ticketEntities = userEntity.getBookedTickets();
        ticketEntities.add(ticketEntity);
        userEntity.setBookedTickets(ticketEntities);

        userRepository.save(userEntity);

        return "Ticket has been added successfully";
    }

    private boolean checkValidityOfRequests(TicketEntryDto ticketEntryDto) {
        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();
        ShowEntity showEntity = showRepository.findById(ticketEntryDto.getShowId()).get();
        List<ShowSeatEntity> showSeatEntityList = showEntity.getListOfShowSeats();
        for (ShowSeatEntity showSeatEntity: showSeatEntityList) {
            String seatNo = showSeatEntity.getSeatNo();
            if (requestedSeats.contains(seatNo) && showSeatEntity.isBooked()) return false;
        }
        return true;
    }

    public List<TicketEntity> getTicketBookedBy(Integer userId) {
        List<TicketEntity> ticketEntityList = ticketRepository.findTicketEntitiesByUserEntityId(userId);
        return ticketEntityList;
    }

    public String cancelTicket(Integer ticketId) {
        TicketEntity ticketEntity = ticketRepository.findById(ticketId).get();
        int showEntityId = ticketEntity.getShowEntity().getId();
        String seatsBooked = ticketEntity.getBookedSeats();
        String seats[] = seatsBooked.split(",\\s*");
        for (String seat: seats) {
            int showSeatId = showSeatRepository.findIdBySeatNo(seat, showEntityId);
            ShowSeatEntity showSeatEntity = showSeatRepository.findById(showSeatId).get();
            showSeatEntity.setBooked(false);
            showSeatEntity.setBookedAt(null);
            showSeatRepository.save(showSeatEntity);
        }
        ticketRepository.deleteById(ticketId);
        return "Ticket deleted successfully";
    }
}
