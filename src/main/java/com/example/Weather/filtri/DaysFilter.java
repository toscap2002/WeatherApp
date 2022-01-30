package com.example.Weather.filtri;

import com.example.Weather.model.City;
import com.example.Weather.model.Lista;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Vector;

public class DaysFilter implements FilterTemplate{

    /**
     * il metodo restituisce gli elementi compresi tra due date
     * @param json
     * @param l
     * @return
     */
    @Override
    public Lista filter(JSONObject json, Lista l) {

        if (json.has("days")) {
            if(json.getInt("days") != 0) {

                int days = json.getInt("days");
                Lista res = new Lista();

                Vector<City> vector = new Vector<City>();
                Date date = new Date();  // data corrente
                LocalDate maxDate = LocalDate.parse(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString()).plusDays(days);
                for (City c : l.getVector()) {
                    LocalDate cityDate;
                    cityDate = c.getdt().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    System.err.println(cityDate);
                    if (maxDate.isEqual(cityDate) || maxDate.isAfter(cityDate)) {
                        vector.add(c);
                    }
                }
                res.setList(vector);
                return res;
            }else{
                return new Lista();
            }
        }else{
            return l;
        }


    }
}
