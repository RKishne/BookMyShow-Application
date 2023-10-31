package com.example.BookMyShow.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter

public class BookTicketRequest {

    private String movieName;
    private Integer threaterId;
    private LocalTime showTime;
    private LocalDate showDate;
    private List<String> requestedSeatNo;
    private Integer userId;
}
