package com.example.BookMyShow.Services;

import com.example.BookMyShow.DTO.AddThreaterRequest;
import com.example.BookMyShow.Enum.SeatType;
import com.example.BookMyShow.Modals.Threater;
import com.example.BookMyShow.Modals.ThreaterSeats;
import com.example.BookMyShow.Repositories.ThreaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThreaterService {
    @Autowired
    private ThreaterRepository threaterRepository;
    public String addThreater(AddThreaterRequest addThreaterRequest) {
        //create threater Entity
        Threater threater= Threater.builder()
                .threaterName(addThreaterRequest.getThreaterName())
                .threaterAddress(addThreaterRequest.getAddress())
                .threaterCity(addThreaterRequest.getCity())
                .build();

        //create threater Seats
        createThreaterSeats(threater,addThreaterRequest);


        return "Threater and its seats have beend saved in DB";
    }

    private void createThreaterSeats(Threater threater, AddThreaterRequest addThreaterRequest) {

        int noOfClassicSeats=addThreaterRequest.getNoOfClassicSeats();
        int noOfPremiumSeats=addThreaterRequest.getNoOfPremiumSeats();
        int noOfGoldSeats=addThreaterRequest.getNoOfGoldSeats();
        int noOfSilverSeats=addThreaterRequest.getNoOfSilverSeats();
        int seatsPerRow=addThreaterRequest.getNoOfSeatsPerRow();

        List<ThreaterSeats> threaterSeatsList=new ArrayList<>();

        int row=0;
        char ch='A';
        for(int i=1;i<=noOfClassicSeats;i++){
            if(i%seatsPerRow==1){
                row++;
                ch='A';
            }
            String seatsNo=ch+""+row;
            ch++;

            ThreaterSeats threaterSeats= ThreaterSeats.builder()
                    .threaterSeatNumber(seatsNo)
                    .threaterSeatType(SeatType.NORMAL)
                    .threater(threater)
                    .build();

            threaterSeatsList.add(threaterSeats);
        }
        //Similarly for premium Seats
        ch='A';
        for(int i=1;i<=noOfPremiumSeats;i++){
            if(i%seatsPerRow==1){
                row++;
                ch='A';
            }
            String seatsNo=ch+""+row;
            ch++;

            ThreaterSeats threaterSeats= ThreaterSeats.builder()
                    .threaterSeatNumber(seatsNo)
                    .threaterSeatType(SeatType.PREMIUM)
                    .threater(threater)
                    .build();

            threaterSeatsList.add(threaterSeats);
        }
        //Similary for gold seats
        ch='A';
        for(int i=1;i<=noOfGoldSeats;i++){
            if(i%seatsPerRow==1){
                row++;
                ch='A';
            }
            String seatsNo=ch+""+row;
            ch++;

            ThreaterSeats threaterSeats= ThreaterSeats.builder()
                    .threaterSeatNumber(seatsNo)
                    .threaterSeatType(SeatType.GOLD)
                    .threater(threater)
                    .build();

            threaterSeatsList.add(threaterSeats);
        }
        //Similarly for Silver Seats
        ch='A';
        for(int i=1;i<=noOfSilverSeats;i++){
            if(i%seatsPerRow==1){
                row++;
                ch='A';
            }
            String seatsNo=ch+""+row;
            ch++;

            ThreaterSeats threaterSeats= ThreaterSeats.builder()
                    .threaterSeatNumber(seatsNo)
                    .threaterSeatType(SeatType.SILVER)
                    .threater(threater)
                    .build();

            threaterSeatsList.add(threaterSeats);
        }
        threater.setThreaterSeatsList(threaterSeatsList);

        threaterRepository.save(threater);
    }
}
