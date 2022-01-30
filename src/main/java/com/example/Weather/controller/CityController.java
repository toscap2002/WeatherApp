package com.example.Weather.controller;

import com.example.Weather.error.Errore;
import com.example.Weather.filtri.Statistiche;
import com.example.Weather.model.City;
import com.example.Weather.model.Lista;
import com.example.Weather.service.CityService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;


/**
 * @author Pierro 
 */

@Controller
public class CityController {

    @Autowired
    public CityController() {
    }

    /**
     * Questa rotta di GET ritorna le informazioni del meteo corrente di una città
     */
    @GetMapping("/current")
    public ResponseEntity<Map<String, Object>> getCity(@RequestParam(required = false) String name) {
        if(!(name == null) && !name.isBlank()) {
            JSONObject jsonObject = new JSONObject(CityService.consumingApi(name).exportJson().toMap());
            return new ResponseEntity<Map<String, Object>>(jsonObject.toMap() , HttpStatus.OK);
        }else{
            return new ResponseEntity<Map<String, Object>>(new JSONObject().toMap(), HttpStatus.OK);
        }
    }

    /**
     * Questa rotta di GET ritona le informazioni delle previsioni meteo di Ancona
     */
    @GetMapping("/forecast")
    public ResponseEntity<Map<String, Object>> getCityForecast(@RequestParam(required = false) String name) {
        if(!(name == null) && !name.isBlank()) {
            return new ResponseEntity<Map<String, Object>>(CityService.apifivedays(name).exportJson().toMap(), HttpStatus.OK);
        }else{
            return new ResponseEntity<Map<String, Object>>(new JSONObject().toMap(), HttpStatus.OK);
        }

    }

    /**
     * Questa rotta di GET ritorna le statistiche riguardanti temperature massima, minima, media e varianza
     */

    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Object>> getStatistics(@RequestParam(required = false) String name) {
        if(!(name == null) && !name.isBlank()) {
            Lista l = CityService.apifivedays(name);
            Statistiche s = new Statistiche();
            s.CalcoloStatistiche(l);
            return new ResponseEntity<Map<String, Object>>(s.toJson().toMap(), HttpStatus.OK);
        }else{
            return new ResponseEntity<Map<String, Object>>(new JSONObject().toMap(), HttpStatus.OK);
        }
    }

    /**
     *Questa rotta di GET ritorna l'errore tra le temperature reali e le previsioni
     */
    @GetMapping("/error")
    public ResponseEntity<Map<String, Object>> getError(@RequestParam(required = false) String name){
        if(!(name == null) && !name.isBlank()) {
            City attuale = CityService.consumingApi(name);
            Lista forecast = CityService.apifivedays(name);
            Errore e = new Errore();
            e.calcolaSogliaErrore(attuale, forecast);
            return new ResponseEntity<Map<String, Object>>(e.toJson().toMap(), HttpStatus.OK);
        }else{
            return new ResponseEntity<Map<String, Object>>(new JSONObject().toMap(), HttpStatus.OK);
        }
    }


    /**
     * questa rotta serve per effettuare il filtraggio sui dati in locale o del forecast 5
     * @param json
     * @return
     */
    @PostMapping("/filter")
    public ResponseEntity<Map<String, Object>> filter(@RequestBody String json) throws IOException {
        if(!(json == null) && !json.isBlank()) {
            JSONObject jobj = new JSONObject(json);
            Lista res = CityService.filter(json);
            if(jobj.has("statistic") && jobj.getBoolean("statistic")){
                Statistiche s = new Statistiche();
                s.CalcoloStatistiche(res);
                return  new ResponseEntity<Map<String, Object>>(s.toJson().toMap(), HttpStatus.OK);
            }
            return  new ResponseEntity<Map<String, Object>>(res.exportJson().toMap(), HttpStatus.OK);
        }else{
            return new ResponseEntity<Map<String, Object>>(new JSONObject().toMap(), HttpStatus.OK);
        }
    }

}
