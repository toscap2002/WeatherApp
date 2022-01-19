package com.example.Weather.controller;

import com.example.Weather.error.Errore;
import com.example.Weather.filtri.Statistiche;
import com.example.Weather.model.City;
import com.example.Weather.model.Lista;
import com.example.Weather.service.CityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CityController {

    CityService cityService;


    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping( "/city")
    public ResponseEntity<City> getCity(){
        return new ResponseEntity<>(cityService.consumingApi(), HttpStatus.OK);
    }

    @GetMapping("/forecast")
    public ResponseEntity<Lista> getCityForecast(){
        return new ResponseEntity<>(cityService.apifivedays(), HttpStatus.OK);
    }

    @GetMapping("/saveEveryHour")
    public ResponseEntity<Object> getEveryHour(){
        return new ResponseEntity<>(cityService.saveHour(), HttpStatus.OK);
    }

    @GetMapping("/saveDay")
    public ResponseEntity<Object> getDay(){
        return new ResponseEntity<>(cityService.saveDay(), HttpStatus.OK);
    }


    @GetMapping("/statistics")
    public ResponseEntity<JSONObject> getStatistics() throws JsonProcessingException {
        Lista l = cityService.apifivedays();
        Statistiche s = new Statistiche();
        s.CalcoloStatistiche(l);
        return new ResponseEntity<>(s.toJson(), HttpStatus.OK);
    }

    @GetMapping("/error")
    public ResponseEntity<JSONObject> getError(){
        City attuale = cityService.consumingApi();
        Lista forecast = cityService.apifivedays();
        Errore e = new Errore();
        e.calcolaSogliaErrore(attuale, forecast);
        return new ResponseEntity<>(e.toJson(), HttpStatus.OK);
    }


}
