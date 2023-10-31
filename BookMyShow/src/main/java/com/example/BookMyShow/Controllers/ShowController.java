package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.DTO.AddShowRequest;
import com.example.BookMyShow.DTO.AddShowSeatRequest;
import com.example.BookMyShow.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    private ShowService showService;

    @PostMapping("/addShow")
    public String addShow(@RequestBody AddShowRequest addShowRequest){
        try{
            String response=showService.addShow(addShowRequest);
            return response;
        }
        catch(Exception e) {
            return e.getMessage();
        }
    }
    @PostMapping("/createShowSeats")
    public String createShowSheats(@RequestBody AddShowSeatRequest addShowSeatRequest){
        String response=showService.createShowSeats(addShowSeatRequest);
        return response;
    }
}
