package com.nikhilprashant.book_my_show_app.Entities;

import com.nikhilprashant.book_my_show_app.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theatre_seats")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private String seatNo;
    @ManyToOne
    @JoinColumn
    private TheatreEntity theatreEntity;
}
