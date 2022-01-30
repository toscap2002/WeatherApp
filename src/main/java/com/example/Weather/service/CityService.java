package com.example.Weather.service;

import com.example.Weather.asinc.ScheduledTasks;
import com.example.Weather.filtri.DaysFilter;
import com.example.Weather.filtri.HourFilter;
import com.example.Weather.filtri.Statistiche;
import com.example.Weather.model.City;
import com.example.Weather.model.Lista;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Pierro
 */


@Service
public class CityService {

    @Autowired
    private static RestTemplate restTemplate;

    @Autowired
    public void ServiceJson(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String parse(String url) {
        return restTemplate.getForObject(url, String.class);
    }


    /**
     * Questo metodo chiama l'API per che restituisce il meteo corrente
     *
     * @param name
     * @return meteo corrente
     */

    public static City consumingApi(String name) {
        String url = "https://api.openweathermap.org/data/2.5/weather?units=metric&appid=";
        String api = "711b077df0c4631f345bd97cfb63616a";
        url += api + "&q=" + name;
        return restTemplate.getForObject(url, City.class);
    }

    /**
     * Questo metodo chiama l'API che restituisce le previsioni meteo per i prossimi 5 giorni
     *
     * @return previsioni meteo
     */
    public static Lista apifivedays(String name) {
        String url = "https://api.openweathermap.org/data/2.5/forecast?units=metric&appid=";
        String api = "641574c5746e92498c743ae79c130f58";
        url += api + "&q=" + name;
        return restTemplate.getForObject(url, Lista.class);
    }


    /**
     * applica i filtri in base al contenuto del json in input
     * @param Json
     * @return
     * @throws IOException
     */
    public static Lista filter(String Json) throws IOException {
        JSONObject requestBody = new JSONObject(Json);

        Lista l;
        if (requestBody.has("forecast5") && requestBody.getBoolean("forecast5")) {
            l = apifivedays(requestBody.getString("name"));
        } else {
            String fileContent = new String(Files.readAllBytes(Path.of(ScheduledTasks.exportPath)));
            JSONArray array = new JSONObject(fileContent).getJSONArray("rilevamenti");
            l = Lista.JsonToList(array);
        }

        Lista res;
        HourFilter hourFilter = new HourFilter();
        DaysFilter daysFilter = new DaysFilter();
        res = daysFilter.filter(requestBody, l);
        res = hourFilter.filter(requestBody, res);

        return res;
    }


}
