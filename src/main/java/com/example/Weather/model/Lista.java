package com.example.Weather.model;

import java.util.Vector;

/**
 * Questa classe descrive tutte le proprietà delle previsioni meteo di una città
 * @author Pierro e Pelliccia
 */

public class Lista  {

    private Vector<City> city = new Vector<>();

    public Lista(){
        super();
    }

    public City getCity(int index) {
        return city.get(index);
    }
    public void setList(Vector<City> city) {
        this.city = city;
    }

    public int getNumeroCitta() {
        return this.city.size();
    }

    @Override
    public String toString(){
        return "Main " + city ;
    }

}
