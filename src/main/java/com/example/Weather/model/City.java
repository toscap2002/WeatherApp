package com.example.Weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Vector;

@JsonIgnoreProperties(ignoreUnknown = true)
public  class City {
/*
L'unica cosa che mi manca è l'errore, però devo modifivare i metodi: forecast, saveHour, toJson per collegare forecast
in saveHour devo fare due metodi ce richiamo così sono un po' diversi, va bene l'api forecast che ho collegato per fare tutto questo
forse po devo collegare quello Historical per fare la differenza
 */
    private Vector<Weather> weather = new Vector<Weather>();
    private String name;
    private Main main;
    private String dt_txt;

    public City(){
        super();
        this.main = null;
    }


    public City(Main main){
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDt_txt(){
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public Object getMain() {
        return main;
    }
    public void setMain(Main main) {
        this.main = main;
    }

    public Vector<Weather> getWeather() {
        return weather;
    }
    public void setWeather(Vector<Weather> weather) {
        this.weather = weather;
    }
    /* JSONObject toJson() throws JSONException {

        JSONObject weather = new JSONObject();

        JSONObject temperature = new JSONObject();
        City c = new City();
        weather.put("temp", temp);
        weather.put("temp_max", c.getTemp_max());
        weather.put("temp_min", c.getTemp_min());
        weather.put("temp_avg", c.getTemp_avg());


        try(FileWriter file = new FileWriter("Ancona.json")) {
            file.write(temperature.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
      *//* Map<Double, Object> main = (Map<Double, Object>) weather.get("main") ;
        main.forEach((key, value)->System.out.println(key+": "+value));*//*

        *//*JSONObject main = new JSONObject();
       double temp = main.getJSONObject("main").getDouble("temp");
        System.out.println("The temperature is: " + temp);
*//*
        *//*JSONObject temp = new JSONObject();
            City c = new City();
            weather.put("temp", temp);
            weather.put("temp_max", c.getTemp_max());
            weather.put("temp_min", c.getTemp_min());
            weather.put("temp_avg", c.getTemp_avg());

            temp.put("Main", weather);*//*

            *//*temp = weather.getDouble("temp");
            System.out.println("The temperature is: " + temp);
            temp_max = weather.getDouble("temp_max");
            System.out.println("The max temperature is: " + temp_max);
            temp_min = weather.getJSONObject("main").getDouble("temp_min");
            System.out.println("The min temperature is: " + temp_min);
            temp_avg = (temp_max + temp_min) / 2;
            System.out.println("The average temperature is:" + temp_avg);*//*

        JSONArray array = new JSONArray();
        for (int i = 0; i < array.length(); i++) {

            Weather w = new Weather();
            weather.put("id", w.getId());
            weather.put("main", w.getMain());

            array.put(weather);

        }
        weather.put("list", array.toString());
        return weather;


    }

    JSONObject JsonM(JSONObject main1) throws JSONException{
        JSONObject main = (JSONObject) main1.get("main");
        double temp = main.getDouble("temp");
        double temp_min = main.getDouble("temp_min");
        double temp_max = main.getDouble("temp_max");
        double temp_avg = (temp_min + temp_max)/2;
        System.out.println("Le temperature sono: " + temp + temp_min + temp_max + temp_avg);
        return main;
    }

*/

    @Override
    public String toString(){
        return "Main{ " + main + "\n}weather: " + weather;
    }



}
