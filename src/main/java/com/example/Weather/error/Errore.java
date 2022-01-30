package com.example.Weather.error;

import com.example.Weather.model.City;
import com.example.Weather.model.Lista;
import com.example.Weather.model.Main;
import org.json.JSONObject;


/**
 * @author Pierro 
 */

public class Errore {
    private double temp_attuale;
    private double temp_forecast;
    private double differenza;

    public Errore() {
        this.temp_attuale = 0;
        this.temp_forecast = 0;
        this.differenza = 0;
    }

    /**
     * Questo è il metodi che calcola l'errore tra le temperature attuali e le previsioni
     * @param current è il parametro indica le temperature attuali
     * @param forecast è il parametro che indica le temperature delle previsioni
     */
    public void calcolaSogliaErrore(City current, Lista forecast){
        // ottengo la temperatura dalla current...
        Main main_current = current.getMain();
        this.temp_attuale = main_current.getTemp();

        // ...e dalla forecast
        City c = forecast.getCity(0);   //0 = prima rilevazione
        Main main_forecast = c.getMain();
        this.temp_forecast = main_forecast.getTemp();


        if (temp_attuale != temp_forecast) {
            if (temp_attuale > temp_forecast) this.differenza = temp_attuale - temp_forecast;
            else if (temp_attuale < temp_forecast) this.differenza = temp_forecast - temp_attuale;
        }
    }

    /**
     * Il metodo restituisce il JSONObject dell'errore
     * @return JSONObject delle temperature
     */
    public JSONObject toJson(){
        JSONObject j = new JSONObject();
        j.put("temp_attuale", temp_attuale);
        j.put("temp_forecast", temp_forecast);
        j.put("differenza", differenza);

        return j;
    }
}
