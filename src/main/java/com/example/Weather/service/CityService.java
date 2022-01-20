package com.example.Weather.service;

import com.example.Weather.model.City;
import com.example.Weather.model.Lista;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Pierro e Pelliccia
 */

@Service
public interface CityService {

    public abstract Object saveHour();
    public abstract Lista apifivedays();
    public abstract String parse(String url);
    public abstract void ServiceJson(RestTemplate restTemplate);
    public abstract City consumingApi();

}
