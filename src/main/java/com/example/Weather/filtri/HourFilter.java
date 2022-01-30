package com.example.Weather.filtri;

import com.example.Weather.model.City;
import com.example.Weather.model.Lista;
import org.json.JSONObject;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Vector;
import java.util.regex.PatternSyntaxException;

public class HourFilter implements FilterTemplate{

    /**
     * il metodo filtra in base all'ora della rilevazione
     * @param json
     * @param l
     * @return
     */
    @Override
    public Lista filter(JSONObject json, Lista l) {
        // ottengo gli orari
        if(json.has("hours")) {
            String[] doubleTimeTest = this.split(json.getString("hours"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime timeStart, timeEnd;

            if (doubleTimeTest != null && doubleTimeTest.length > 1) {
                timeStart = LocalTime.parse(doubleTimeTest[0]);
                timeEnd = LocalTime.parse(doubleTimeTest[1]);
            } else {
                timeStart = LocalTime.parse(json.getString("range"));
                timeEnd = null;
            }

            Lista res = new Lista();
            Vector<City> vector = new Vector<City>();
            for (City c : l.getVector()) {
                LocalTime cityTime;
                cityTime = LocalTime.of(c.getdt().getHours(), c.getdt().getMinutes(), c.getdt().getSeconds());
                if (cityTime.isAfter(timeStart) && cityTime.isBefore(timeEnd)) {
                    vector.add(c);
                }
            }
            res.setList(vector);
            return res;
        }else{
            return l;
        }


    }

    private String[] split(String range) {
        String[] times;
        try {
            times = range.split(",");
        } catch (PatternSyntaxException e) {
            times = null;
        }

        return times;
    }

}
