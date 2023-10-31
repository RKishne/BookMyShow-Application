package com.example.BookMyShow.Repositories;

import com.example.BookMyShow.Modals.Movie;
import com.example.BookMyShow.Modals.Show;
import com.example.BookMyShow.Modals.Threater;
import com.example.BookMyShow.Modals.ThreaterSeats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ShowRepository extends JpaRepository<Show,Integer> {

    Show findShowByShowDateAndShowTimeAndMovieAndThreater(LocalDate showDate, LocalTime showTime, Movie movie, Threater threater);
}
