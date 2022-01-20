package com.example.Weather.controller;

import com.example.Weather.error.Errore;
import com.example.Weather.filtri.Statistiche;
import com.example.Weather.model.City;
import com.example.Weather.model.Lista;
import com.example.Weather.service.CityService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Pierro e Pelliccia
 */

@Controller
public class CityController {

    CityService cityService;


    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    /**
     * Questa rotta di GET ci mostra le informazioni del meteo corrente di Ancona
     */
    @GetMapping( "/city")
    public ResponseEntity<City> getCity(){
        return new ResponseEntity<>(cityService.consumingApi(), HttpStatus.OK);
    }

    /**
     * Questa rotta di GET ci mostra le informazioni delle previsioni meteo di Ancona
     */
    @GetMapping("/forecast")
    public ResponseEntity<Lista> getCityForecast(){
        return new ResponseEntity<>(cityService.apifivedays(), HttpStatus.OK);
    }

    /**
     * Questa rotta di GET salva le informazioni
     */
    @GetMapping("/saveEveryHour")
    public ResponseEntity<Object> getEveryHour(){
        return new ResponseEntity<>(cityService.saveHour(), HttpStatus.OK);
    }

    /**
     *Questa rotta di GET ci mostra le statistiche riguardanti temperature massima, minima, media e varianza
     */
    @GetMapping("/statistics")
    public ResponseEntity<JSONObject> getStatistics(){
        Lista l = cityService.apifivedays();
        Statistiche s = new Statistiche();
        s.CalcoloStatistiche(l);
        return new ResponseEntity<>(s.toJson(), HttpStatus.OK);
    }

    /**
     *Questa rotta di GET di da l'errore tra le temperature reali e le previsioni
     */
    @GetMapping("/error")
    public ResponseEntity<JSONObject> getError(){
        City attuale = cityService.consumingApi();
        Lista forecast = cityService.apifivedays();
        Errore e = new Errore();
        e.calcolaSogliaErrore(attuale, forecast);
        return new ResponseEntity<>(e.toJson(), HttpStatus.OK);
    }


}
