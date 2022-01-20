package com.example.Weather.error;

/**
 * @author Pierro e Pelliccia
 */

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super("The city doesn't exist");
    }
}
