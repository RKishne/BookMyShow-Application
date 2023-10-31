package com.example.BookMyShow.Exceptions;

public class SeatsBookedAlready extends Exception{
    public SeatsBookedAlready(String message) {
        super(message);
    }
}
