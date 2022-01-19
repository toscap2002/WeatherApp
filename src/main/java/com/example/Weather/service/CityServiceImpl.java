package com.example.Weather.service;

import com.example.Weather.model.City;
import com.example.Weather.model.Lista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public void ServiceJson(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String parse(String url) {
       return restTemplate.getForObject(url, String.class);
    }


    @Override
    public City consumingApi() {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=ancona&appid=";
        String api = "711b077df0c4631f345bd97cfb63616a";
        return restTemplate.getForObject(url+api, City.class);
    }

    @Override
    public Lista apifivedays(){
        String url = "http://api.openweathermap.org/data/2.5/forecast?q=ancona&appid=";
        String api_key = "641574c5746e92498c743ae79c130f58";

        return restTemplate.getForObject(url+api_key, Lista.class);
    }

   /* public JSONObject toJson() throws JSONException {

        Main main_t = new Main();


        JSONObject weather = new JSONObject();

        JSONObject main = new JSONObject();
        main.put("temp", (main_t.getTemp()));
        main.put("feels_like", (main_t.getFeels_like()));
        main.put("temp_max", (main_t.getTemp_max()));
        main.put("temp_min", (main_t.getTemp_min()));
        main.put("temp_avg", (main_t.getTemp_avg()));


        JSONArray array = new JSONArray();
        for (int i = 0; i < array.size(); i++) {

            Weather w = new Weather();
            weather.put("id", w.getId());
            weather.put("main", w.getMain());

            array.add(weather);
        }

        weather.put("list", array.toString());
        return weather;

    }*/

    @Override  //salva ogni ora
    public Object saveHour(){
    String path = System.getProperty("user.dir") + "HourlyReport.txt";
    File file_h = new File(path);

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Lista city = apifivedays();

            try{
               if(!file_h.exists()){
               file_h.createNewFile();
               }
               FileWriter fileWriter = new FileWriter(file_h, true);
               BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
               bufferedWriter.write(city.toString());
               bufferedWriter.write("\n");
               bufferedWriter.close();
            } catch(IOException e){
               System.out.println(e);
               }

            }
        }, 0,3, TimeUnit.HOURS);
        return "The file is saved in: " + path;
    }

    @Override  //salva ogni giorno
    public Object saveDay(){
        String path = System.getProperty("user.dir") + "DailyReport.txt";
        File file_d = new File(path);

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Lista city = apifivedays();

                try{
                    FileWriter fileWriter = new FileWriter(file_d, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(city.toString());
                    bufferedWriter.write("\n");
                    bufferedWriter.close();
                } catch(IOException e){
                    System.out.println(e);
                }

            }
        }, 0, 1, TimeUnit.DAYS);
        return "The file is saved in: " + path;
    }



    /*@Override
    public JSONObject toJson() throws JSONException, IOException {

            JSONObject weather = new JSONObject();


            double temp = weather.getJSONObject("main").getDouble("temp");
            System.out.println("The temperature is: " + temp);
            double temp_max =  weather.getJSONObject("main").getDouble("temp_max");
            System.out.println("The max temperature is: " + temp_max);
            double temp_min = weather.getJSONObject("main").getDouble("temp_min");
            System.out.println("The min temperature is: " + temp_min);
            double temp_avg = (temp_max+temp_min)/2;
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


    }*/

}
