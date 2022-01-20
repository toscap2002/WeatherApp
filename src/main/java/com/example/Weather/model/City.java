package com.example.Weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Vector;

/**
 * Questa è la classe che descrive le caratteristiche del meteo corrente di una città
 * @author Pierro e Pelliccia
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public  class City {

    private Vector<Weather> weather = new Vector<Weather>();
    private String name;
    private Main main;
    private String dt_txt;

    public City(){
        super();
        this.main = null;
    }


    public City(Main main){
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDt_txt(){
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public Main getMain() {
        return main;
    }
    public void setMain(Main main) {
        this.main = main;
    }

    public Vector<Weather> getWeather() {
        return weather;
    }
    public void setWeather(Vector<Weather> weather) {
        this.weather = weather;
    }

    @Override
    public String toString(){
        return "Main{ " + main + "\n}weather: " + weather;
    }


}
