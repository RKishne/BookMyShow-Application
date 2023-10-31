package com.example.BookMyShow.DTO;

import com.example.BookMyShow.Enum.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddThreaterRequest {

    private String threaterName;

    private String address;

    private City city;

    private Integer noOfClassicSeats;

    private Integer noOfPremiumSeats;

    private Integer noOfGoldSeats;

    private Integer noOfSilverSeats;

    private Integer noOfSeatsPerRow;

}
