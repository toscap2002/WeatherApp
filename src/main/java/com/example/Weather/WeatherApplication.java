package com.example.Weather;

import com.example.Weather.config.Settings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class WeatherApplication {
    /**
     * istanza classe setting e inizializzazione nome città
     */
    public static Settings settings = new Settings("Peio,IT");

    /**
     * metodo principale
     * @param args
     */
    public static void main(String[] args) {

        SpringApplication.run(WeatherApplication.class, args);

    }

}
