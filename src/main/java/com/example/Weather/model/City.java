package com.example.Weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Vector;

/**
 * Questa è la classe che descrive le caratteristiche del meteo corrente di una città
 *
 * @author Pierro 
 */

public class City {

    private String name;
    private Main main;
    private long dt;

    public City() {
        this.main = null;

    }


    public City(Main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getdt() {
        return new Date(this.dt * 1000);
    }

    public void setdt(long dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public JSONObject exportJson() {
        JSONObject res = new JSONObject();
        res.put("name", this.name);
        res.put("temperature", this.main.exportJSON());
        res.put("dt", this.dt);
        return res;
    }

}
