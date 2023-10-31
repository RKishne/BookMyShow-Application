package com.example.BookMyShow.Services;

import com.example.BookMyShow.DTO.AddMovieRequest;
import com.example.BookMyShow.Exceptions.MovieIsAlreadyPresent;
import com.example.BookMyShow.Modals.Movie;
import com.example.BookMyShow.Repositories.MovieRepository;
import com.example.BookMyShow.Transforms.MovieTransforms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public String addMovie(AddMovieRequest addMovieRequest) throws MovieIsAlreadyPresent {
        List<Movie> movieList=movieRepository.findAll();

        for(Movie movie:movieList){
            if(movie.getMovieName().equals(addMovieRequest.getMovieName())){
                throw new MovieIsAlreadyPresent("Movie Is Already present In the DB");
            }
        }
        Movie movie= MovieTransforms.convertAddMovieRequestToMovieEntity(addMovieRequest);

        movieRepository.save(movie);

        return "Movie has been added Successfully in the DB with Id"+movie.getMovieId()+" and Movie Name "+movie.getMovieName();
    }
}
