package com.example.Weather.error;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super("The city doesn't exist");
    }
}
