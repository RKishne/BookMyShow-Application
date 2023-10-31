package com.example.BookMyShow.Modals;

import com.example.BookMyShow.Enum.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "threaterSeats")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThreaterSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer threaterSeatId;

    private String threaterSeatNumber;

    @Enumerated(value = EnumType.STRING)
    private SeatType threaterSeatType;

    @JsonIgnore
    @JoinColumn
    @ManyToOne
    private Threater threater;
}
