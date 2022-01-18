package com.example.Weather.model;

import net.minidev.json.JSONObject;
import org.json.JSONException;
import org.json.simple.JSONArray;

public class ToJson extends Weather {
    Weather weather = new Weather();
    Main main_t = new Main();
     public JSONObject toJson(String name) throws JSONException {



        JSONObject weather = new JSONObject();

        JSONObject main = new JSONObject();
        main.put("temp", (main_t.getTemp()));
        main.put("feels_like", (main_t.getFeels_like()));
        main.put("temp_max", (main_t.getTemp_max()));
        main.put("temp_min", (main_t.getTemp_min()));
        main.put("temp_avg", (main_t.getTemp_avg()));


        JSONArray array = new JSONArray();
        for (int i = 0; i < array.size(); i++) {

            Weather w = new Weather();
            weather.put("id", w.getId());
            weather.put("main", w.getMain());

            array.add(weather);
        }

        weather.put("list", array.toString());
        return weather;

    }
}
