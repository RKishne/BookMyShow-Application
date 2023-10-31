package com.example.BookMyShow.Exceptions;

public class MovieIsAlreadyPresent extends Exception{
    public MovieIsAlreadyPresent(String message) {
        super(message);
    }
}
