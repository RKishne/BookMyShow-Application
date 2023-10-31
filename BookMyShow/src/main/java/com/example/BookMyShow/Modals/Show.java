package com.example.BookMyShow.Modals;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;
    private LocalDate showDate;
    private LocalTime showTime;

    @JsonIgnore
    @JoinColumn
    @ManyToOne
    private Movie movie;

    @JsonIgnore
    @JoinColumn
    @ManyToOne
    private Threater threater;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeats> showSeatsList=new ArrayList<>();

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Ticket> ticketList=new ArrayList<>();
}
