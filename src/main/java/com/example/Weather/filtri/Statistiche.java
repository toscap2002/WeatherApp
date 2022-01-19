package com.example.Weather.filtri;

import com.example.Weather.model.City;
import com.example.Weather.model.Lista;
import com.example.Weather.model.Main;

import java.util.Vector;

public class Statistiche {
    private Main main;
    private Vector<City> city = new Vector<>();
    private Lista list;


    public Statistiche(Main main){
        this.main = main;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Vector<City> getCity() {
        return city;
    }

    public Lista getList() {
        return list;
    }

    public void setList(Lista list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Statistiche{" +
                main +
                '}';
    }
}
