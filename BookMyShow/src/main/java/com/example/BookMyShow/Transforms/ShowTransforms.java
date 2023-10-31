package com.example.BookMyShow.Transforms;

import com.example.BookMyShow.DTO.AddShowRequest;
import com.example.BookMyShow.Modals.Show;

public class ShowTransforms {

    public static Show convertAddShowRequestToShowEntity(AddShowRequest addShowRequest){
        Show show= Show.builder()
                .showTime(addShowRequest.getShowTime())
                .showDate(addShowRequest.getShowDate())
                .build();
        return show;
    }
}
