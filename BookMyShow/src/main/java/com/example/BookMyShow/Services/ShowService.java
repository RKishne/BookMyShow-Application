package com.example.BookMyShow.Services;

import com.example.BookMyShow.DTO.AddShowRequest;
import com.example.BookMyShow.DTO.AddShowSeatRequest;
import com.example.BookMyShow.Enum.SeatType;
import com.example.BookMyShow.Exceptions.ThreaterNotFound;
import com.example.BookMyShow.Modals.*;
import com.example.BookMyShow.Repositories.MovieRepository;
import com.example.BookMyShow.Repositories.ShowRepository;
import com.example.BookMyShow.Repositories.ThreaterRepository;
import com.example.BookMyShow.Transforms.ShowTransforms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ThreaterRepository threaterRepository;
    public String addShow(AddShowRequest addShowRequest) throws ThreaterNotFound {

        Show show= ShowTransforms.convertAddShowRequestToShowEntity(addShowRequest);
        Movie movie=movieRepository.findByMovieName(addShowRequest.getMovieName());

        Optional<Threater> threaterOptional=threaterRepository.findById(addShowRequest.getThreaterId());

        if(!threaterOptional.isPresent()){
            throw new ThreaterNotFound("Threater not present in the DB");
        }
        Threater threater=threaterOptional.get();

        show.setMovie(movie);
        show.setThreater(threater);

        threater.getShowList().add(show);
        movie.getShowList().add(show);

        show =showRepository.save(show);

        return "Show added successfully in the DB with Id "+show.getShowId();
    }

    public String createShowSeats(AddShowSeatRequest addShowSeatRequest) {
        //I need to create the show Seats and save to the DB.

        Show show=showRepository.findById(addShowSeatRequest.getShowId()).get();
        Threater threater=show.getThreater();
        List<ThreaterSeats> threaterSeatsList=threater.getThreaterSeatsList();

        List<ShowSeats> showSeatsList=new ArrayList<>();

        for(ThreaterSeats threaterSeat:threaterSeatsList){

            ShowSeats showSeat= ShowSeats.builder()
                    .showSeatNumber(threaterSeat.getThreaterSeatNumber())
                    .showSeatType(threaterSeat.getThreaterSeatType())
                    .isAvailable(true)
                    .isFoodAttached(false)
                    .show(show)
                    .build();

            if(threaterSeat.getThreaterSeatType().equals(SeatType.NORMAL)){
                showSeat.setPrice(addShowSeatRequest.getPriceOfNormalSeats());
            }
            else if(threaterSeat.getThreaterSeatType().equals(SeatType.PREMIUM)){
                showSeat.setPrice(addShowSeatRequest.getPriceOfPremiumSeats());
            }
            else if (threaterSeat.getThreaterSeatType().equals(SeatType.GOLD)) {
                showSeat.setPrice(addShowSeatRequest.getPriceOfGoldSeats());
            }
            else{
                showSeat.setPrice(addShowSeatRequest.getPriceOfSilverSeats());
            }
            showSeatsList.add(showSeat);
        }
        show.setShowSeatsList(showSeatsList);

        showRepository.save(show);

        return "show seats have been added successfully.";
    }
}
