package com.example.BookMyShow.Modals;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    private String movieName;

    private Integer totalPrice;

    private String bookedSeats;

    private LocalDate showDate;

    private LocalTime showTime;

    private String threaterAddress;

    @JsonIgnore
    @JoinColumn
    @ManyToOne
    private Show show;

    @JsonIgnore
    @JoinColumn
    @ManyToOne
    private User user;
}
