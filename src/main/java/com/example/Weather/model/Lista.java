package com.example.Weather.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Vector;

/**
 * Questa classe descrive tutte le proprietà delle previsioni meteo di una città
 * @author Pierro e Pelliccia
 */

public class Lista  {

    private Vector<City> city = new Vector<>();

    public Lista(){
    }

    public City getCity(int index) {
        return city.get(index);
    }
    public void setList(Vector<City> city) {
        this.city = city;
    }
    public Vector<City> getVector(){
        return this.city;
    }

    public int getNumeroCitta() {
        return this.city.size();
    }

    public JSONObject exportJson(){
        JSONObject res = new JSONObject();
        JSONArray array = new JSONArray();
        for(City c : this.city){
            array.put(c.exportJson());
        }
        res.put("List",array);
        return res;
    }

    /**
     * il metodo statico può essere richiamato senza istanziare la classe e serve per convertire un jsonObject in una Lista
     * @param array
     * @return
     */
    public static Lista JsonToList(JSONArray array){
        Lista res = new Lista();
        Vector<City> vector = new Vector<City>();
        for (Object jobj : array){
            JSONObject json = (JSONObject) jobj;
            City c = new City();
            c.setdt(json.getLong("dt"));
            c.setName(json.getString("name"));
            JSONObject temperature = json.getJSONObject("temperature");
            Main m = new Main(temperature.getDouble("Temperature"), temperature.getDouble("feels_like"), temperature.getDouble("temp_max"), temperature.getDouble("temp_min"), temperature.getDouble("temp_avg"));
            c.setMain(m);
            vector.add(c);
        }
        res.setList(vector);
        return res;
    }

}
