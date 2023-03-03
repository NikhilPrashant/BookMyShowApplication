package com.nikhilprashant.book_my_show_app.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ticketId = UUID.randomUUID().toString();
    private int totalAmount;
    private String movieName;
    private LocalTime showTiming;
    private String theatreName;
    private String bookedSeats;

    @ManyToOne
    @JoinColumn
    UserEntity userEntity;

    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;
}
