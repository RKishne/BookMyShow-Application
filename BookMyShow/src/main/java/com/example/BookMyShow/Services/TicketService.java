package com.example.BookMyShow.Services;

import com.example.BookMyShow.DTO.BookTicketRequest;
import com.example.BookMyShow.Exceptions.MovieNotFound;
import com.example.BookMyShow.Exceptions.SeatsBookedAlready;
import com.example.BookMyShow.Exceptions.ShowNotFound;
import com.example.BookMyShow.Exceptions.ThreaterNotFound;
import com.example.BookMyShow.Modals.*;
import com.example.BookMyShow.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ThreaterRepository threaterRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private UserRepository userRepository;
    public String bookTicket(BookTicketRequest bookTicketRequest) throws Exception {
        try{
            Show show=findRightShbow(bookTicketRequest);

            List<ShowSeats> showSeatsList=show.getShowSeatsList();

            int totalPrice=0;
            for(ShowSeats showSeat:showSeatsList){
                if(bookTicketRequest.getRequestedSeatNo().contains(showSeat.getShowSeatNumber())){
                    if(showSeat.isAvailable()==false){
                        throw new SeatsBookedAlready("Seats booked already. please select another unbooked seats");
                    }
                    totalPrice=totalPrice+showSeat.getPrice();
                    showSeat.setAvailable(false);
                }
            }
            User user=userRepository.findById(bookTicketRequest.getUserId()).get();

            Ticket ticket= Ticket.builder()
                    .bookedSeats(bookTicketRequest.getRequestedSeatNo().toString())
                    .movieName(bookTicketRequest.getMovieName())
                    .showTime(bookTicketRequest.getShowTime())
                    .showDate(bookTicketRequest.getShowDate())
                    .threaterAddress(show.getThreater().getThreaterAddress())
                    .totalPrice(totalPrice)
                    .user(user)
                    .show(show)
                    .build();
            show.getTicketList().add(ticket);
            user.getTicketList().add(ticket);

            ticket =ticketRepository.save(ticket);
            SimpleMailMessage mailMessage=new SimpleMailMessage();

            String body="Hi "+user.getUserName()+" ! "+"You have successfully booked ticket whose ticket id is  "+ticket.getTicketId()+" and movie name is "+show.getMovie().getMovieName()+" and show date is "+show.getShowDate();

            mailMessage.setFrom("hr5235577@gmail.com");
            mailMessage.setTo(user.getEmailId());
            mailMessage.setSubject("ThankYou for Booking tickets from "+show.getThreater().getThreaterName()+" threater 🙏");
            mailMessage.setText(body);

            mailSender.send(mailMessage);


            return "Ticket Has been booked for show Id is "+show.getShowId();
        }
        catch(MovieNotFound e){
            throw new Exception("Movie is not released yet or not found");
        }
        catch (ThreaterNotFound e){
            throw new Exception("You entered wrong threater ID.");
        }
        catch (ShowNotFound e){
            throw new Exception("show is not found");
        }

    }

    private Show findRightShbow(BookTicketRequest bookTicketRequest) throws MovieNotFound, ThreaterNotFound, ShowNotFound {
        Movie movie=movieRepository.findByMovieName(bookTicketRequest.getMovieName());

        if(movie==null){
            throw new MovieNotFound("Movie is not released yet");
        }
        Optional<Threater> threaterOptional=threaterRepository.findById(bookTicketRequest.getThreaterId());
        if(!threaterOptional.isPresent()){
            throw new ThreaterNotFound("You entered wrong threater ID.");
        }
        Threater threater=threaterOptional.get();

        Show show=showRepository.findShowByShowDateAndShowTimeAndMovieAndThreater(bookTicketRequest.getShowDate(),bookTicketRequest.getShowTime(),movie,threater);

        if(show==null){
            throw new ShowNotFound("Show is not found At that thretaer whose id is "+threater.getThreaterId()+" or show is not present with that "+movie.getMovieName());
        }
        return show;
    }
}
