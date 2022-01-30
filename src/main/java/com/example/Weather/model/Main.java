package com.example.Weather.model;

import org.json.JSONObject;

/**
 * Questo metodo descrive tutte le temperature del meteo
 *
 * @author Pierro e Pelliccia
 */

public class Main {
    private double temp;
    private double feels_like;
    private double temp_max;
    private double temp_min;
    private double temp_avg;

    public Main() {
    }

    public Main(double temp, double feels_like, double temp_max, double temp_min, double temp_avg) {
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.temp_avg = temp_avg;
    }


    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_avg() {
        return (temp_max + temp_min) / 2;
    }

    public void setTemp_avg(double temp_avg) {
        this.temp_avg = (temp_max + temp_min) / 2;
    }


    public JSONObject exportJSON() {
        JSONObject res = new JSONObject();
        res.put("Temperature", this.temp);
        res.put("temp_max", this.temp_max);
        res.put("temp_min", this.temp_min);
        res.put("temp_avg", this.temp_avg);
        res.put("feels_like", this.feels_like);
        return res;
    }

    @Override
    public String toString() {

        return "\nTemperature{ " +
                "\ntemp: " + temp + "k" +
                "\n feels_like: " + feels_like +
                "\n temp_max: " + temp_max + "k" +
                "\n temp_min: " + temp_min + "k" +
                "\n temp_avg: " + temp_avg + "k" +
                "}";
    }

}
