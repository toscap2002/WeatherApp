package com.example.Weather;

import com.example.Weather.model.City;
import com.example.Weather.service.CityServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class WeatherApplication {
    public static City Ancona;
    public static CityServiceImpl connessione;
    public static void main(String[] args)  {
        SpringApplication.run(WeatherApplication.class, args);
       /*CityService cityservice = new CityServiceImpl();
       cityservice.consumingApi();*/

        /*connessione.getCityWeather("Ancona");
        System.out.println(Ancona.toString());*/



        //devo richiamare la classe che mi salva ogni ora, giorno e settimana, le varie caratteristiche
        //devo richimare le classi che indicano le previsioni e le temperature effettive
        /* CityServiceImpl service = new CityServiceImpl();
        service.saveEveryHour("Roma");
        Statistics statistics = new Statistics();
        statistics.temperature(set.Temperature());


         */
    }

}
