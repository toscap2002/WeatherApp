package com.example.Weather.service;

import com.example.Weather.model.City;
import com.example.Weather.model.Lista;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public interface CityService {


    /**
     * e vedo se fare almeno uno per tre giorni (se è facile)
     * poi mi manca l'errore tra reale e forecast
     */
    public abstract Object saveHour();
    public abstract Object saveDay();
    //public abstract String forecast() throws Exception;
    public abstract Lista apifivedays();
    public abstract String parse(String url);
    public abstract void ServiceJson(RestTemplate restTemplate);
    public abstract City consumingApi();
    // public abstract Object toJson() throws JSONException, IOException;



}
