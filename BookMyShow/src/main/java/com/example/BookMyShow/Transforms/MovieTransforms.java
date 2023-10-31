package com.example.BookMyShow.Transforms;

import com.example.BookMyShow.DTO.AddMovieRequest;
import com.example.BookMyShow.Modals.Movie;

public class MovieTransforms {

    public static Movie convertAddMovieRequestToMovieEntity(AddMovieRequest addMovieRequest){
        Movie movie= Movie.builder()
                .movieName(addMovieRequest.getMovieName())
                .genre(addMovieRequest.getGenre())
                .duration(addMovieRequest.getDuration())
                .rating(addMovieRequest.getRating())
                .releaseDate(addMovieRequest.getReleaseDate())
                .build();

        return movie;
    }
}
