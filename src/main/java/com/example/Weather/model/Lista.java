package com.example.Weather.model;

import java.util.Vector;

public class Lista {

    private Vector<City> city = new Vector<>();

    public Lista(){
        super();

    }

    public Vector<City> getList() {
        return city;
    }
    public void setList(Vector<City> city) {
        this.city = city;
    }

    @Override
    public String toString(){
        return "Main " + city ;
    }

}
