package com.example.Weather.filtri;

import com.example.Weather.model.Main;

public class Statistiche {
    private Main main;

    public Statistiche(){
        super();
    }

    public Statistiche(Main main){
        this.main = main;
    }


    @Override
    public String toString() {
        return "Statistiche{" +
                main +
                '}';
    }
}
