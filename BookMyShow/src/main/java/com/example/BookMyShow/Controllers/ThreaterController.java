package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.DTO.AddThreaterRequest;
import com.example.BookMyShow.Services.ThreaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/threater")
public class ThreaterController {
    @Autowired
    private ThreaterService threaterService;
    @PostMapping("/addThreater")
    public ResponseEntity addThreater(@RequestBody AddThreaterRequest addThreaterRequest){
        String response=threaterService.addThreater(addThreaterRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
