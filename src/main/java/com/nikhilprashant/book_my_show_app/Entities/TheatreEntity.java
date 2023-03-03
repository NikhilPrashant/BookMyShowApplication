package com.nikhilprashant.book_my_show_app.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theatres")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String name;
    private String location;

    @OneToMany(mappedBy = "theatreEntity", cascade = CascadeType.ALL)
    private List<TheatreSeatEntity> theatreSeatEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "theatreEntity", cascade = CascadeType.ALL)
    private List<ShowEntity> showEntityList = new ArrayList<>();
}
