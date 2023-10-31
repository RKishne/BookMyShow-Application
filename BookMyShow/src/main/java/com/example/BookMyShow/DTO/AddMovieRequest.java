package com.example.BookMyShow.DTO;

import com.example.BookMyShow.Enum.Genre;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddMovieRequest {

    private String movieName;

    private Integer duration;

    private double rating;

    private LocalDate releaseDate;

    private Genre genre;
}
