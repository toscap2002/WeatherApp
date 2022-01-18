package com.example.Weather.model;

public class Weather {
    private Long id;
    private String main;


    public Weather(){}

    public Weather(long id,String main) {
        super();
        this.id = id;
        this.main = main;

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }
    public void setMain(String main) {
        this.main = main;
    }




   /* @Override
    public JSONObject toJson() throws JSONException, IOException {

        JSONObject weather = new JSONObject();


        double temp = weather.getJSONObject("main").getDouble("temp");
        System.out.println("The temperature is: " + temp);
        double temp_max = weather.getJSONObject("main").getDouble("temp_max");
        System.out.println("The max temperature is: " + temp_max);
        double temp_min = weather.getJSONObject("main").getDouble("temp_min");
        System.out.println("The min temperature is: " + temp_min);
        double temp_avg = (temp_max + temp_min) / 2;
        System.out.println("The average temperature is:" + temp_avg);
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
*/


    @Override
    public String toString(){

        return"Id: " + id +", main: " + main;
    }

}
