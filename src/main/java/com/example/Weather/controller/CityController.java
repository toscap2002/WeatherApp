package com.example.Weather.controller;

import com.example.Weather.error.NotFoundException;
import com.example.Weather.filtri.StatisticheDiff;
import com.example.Weather.model.City;
import com.example.Weather.model.Lista;
import com.example.Weather.service.CityService;
import com.fasterxml.jackson.core.JsonProcessingException;
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
    public ResponseEntity<String> getStatistics() throws JsonProcessingException {
        StatisticheDiff statisticheS = new StatisticheDiff();
        String difference = null;
        try{
            difference = statisticheS.compareStatic();
        }catch (NotFoundException | JsonProcessingException e){
            throw new NotFoundException();
        }

        return new ResponseEntity<>(statisticheS.compareStatic(), HttpStatus.OK);
    }


}
