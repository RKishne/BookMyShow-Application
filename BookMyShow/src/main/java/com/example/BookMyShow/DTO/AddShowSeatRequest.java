package com.example.BookMyShow.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddShowSeatRequest {
    private Integer showId;
    private Integer priceOfNormalSeats;
    private Integer priceOfPremiumSeats;
    private Integer priceOfGoldSeats;
    private Integer priceOfSilverSeats;
}
