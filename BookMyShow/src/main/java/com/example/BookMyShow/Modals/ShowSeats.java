package com.example.BookMyShow.Modals;

import com.example.BookMyShow.Enum.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "showSeats")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private String showSeatNumber;

    @Enumerated(value = EnumType.STRING)
    private SeatType showSeatType;

    private Integer price;
    private boolean isAvailable;

    private boolean isFoodAttached;

    @JsonIgnore
    @JoinColumn
    @ManyToOne
    private Show show;
}
