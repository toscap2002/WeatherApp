package com.example.Weather.filtri;

import com.example.Weather.model.City;
import com.example.Weather.model.Lista;
import com.example.Weather.model.Main;
import org.json.JSONObject;

/**
 * @author Pierro e Pelliccia
 */

public class Statistiche {
    private double temp_max = 0;
    private double temp_min = 0;
    private double temp_avg = 0;
    private double variance = 0;


    /**
     * Questo metodo restituisce il JSONObject delle statistiche
     * @return il JSONObject rappresenta le temperature
     */
    public JSONObject toJson(){
        JSONObject temp = new JSONObject();
        temp.put("temp_max", temp_max);
        temp.put("temp_min", temp_min);
        temp.put("temp_avg", temp_avg);
        temp.put("variance", variance);

        return temp;
    }

    /**
     * Questo metodo calcola le statistiche riguardanti le temperature massime, minime, media e varianza
     * @param lista
     */
    public void CalcoloStatistiche(Lista lista){
        double temp_max = 0;
        double temp_min = 0;
        double temp_avg = 0;
        double variance = 0;
        int i;

        for(i = 0; i<lista.getNumeroCitta(); i++){
            City c = lista.getCity(i);
            Main m = c.getMain();

            // solo per la prima rilevazione della lista...
            if (temp_max == 0 && temp_min == 0) {
                temp_min = m.getTemp();
                temp_max = m.getTemp();
            }

            if (m.getTemp() > temp_max)
                temp_max = m.getTemp();

            if (m.getTemp() < temp_min)
                temp_min = m.getTemp();

            temp_avg += m.getTemp();
        }

        temp_avg = temp_avg / i;
        variance = Math.pow((temp_max+temp_min), 2);

        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.temp_avg = temp_avg;
        this.variance = variance;
    }


}
