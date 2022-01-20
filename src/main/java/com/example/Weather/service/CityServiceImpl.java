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


    /**
     * Questo metodo chiama l'API per che restituisce il meteo corrente
     * @return meteo corrente
     */
    @Override
    public City consumingApi() {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=ancona&appid=";
        String api = "711b077df0c4631f345bd97cfb63616a";
        return restTemplate.getForObject(url+api, City.class);
    }

    /**
     * Questo metodo chiama l'API che restituisce le previsioni meteo per i prossimi 5 giorni
     * @return previsioni meteo
     */
    @Override
    public Lista apifivedays(){
        String url = "http://api.openweathermap.org/data/2.5/forecast?q=ancona&appid=";
        String api_key = "641574c5746e92498c743ae79c130f58";

        return restTemplate.getForObject(url+api_key, Lista.class);
    }

    /**
     * Questo meteo salva ogni ora le caratteriscihe rigurdanti le temperature e il meteo
     * @return le temperature del meteo ogni 3 ore
     */
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


}
