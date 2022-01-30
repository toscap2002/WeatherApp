package com.example.Weather.asinc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;

import com.example.Weather.WeatherApplication;
import com.example.Weather.model.City;
import com.example.Weather.service.CityService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Pierro
 */


@Component
public class ScheduledTasks {
    private String path = "HourlyReport.json";
    public static String exportPath ="HourlyReport.json";

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * metodo per lo scheduling per il salvataggio su file delle rilevazioni correnti
     * @throws IOException
     */
    /*  imposto il cron per lo scheduling, vedi documentazione
        https://spring.io/blog/2020/11/10/new-in-spring-5-3-improved-cron-expressions
    */
    @Scheduled(cron = "@hourly")  // ogni ora
    //@Scheduled(cron = "*/5 * * * * *")  // ogni 5 secondi
    public void reportCurrentTime() throws IOException {
        try {
            // qui c'è tutto il contenuto del file
            String fileContent = new String(Files.readAllBytes(Path.of(this.path)));
            JSONObject json = new JSONObject(fileContent);
            JSONArray array = json.getJSONArray("rilevamenti");
            City city = CityService.consumingApi(WeatherApplication.settings.city);

            // controllo se la data della rilevazione corrente è uguale a quella dell'ultima rilevazione
            if(!array.get(array.length()-1).toString().equals(city.exportJson().toString())){
                array.put(city.exportJson());
                // creo writer
                FileWriter file = new FileWriter(this.path, false);
                // scrivo il json su file
                file.write(json.toString());
                // chiudo canale di scrittura
                file.close();
                System.out.println("Scrivo rilevazione del " + city.getdt());
            }

        } catch (NoSuchFileException e) {
            // se il file non esiste lo creo e ci scrivo un array che contiene 1 solo rilevamento
            this.writeNewReportFile();
        } catch (IOException e) {
            System.err.println("errore - errore di i/o: " + e.toString());
        } catch (org.json.JSONException e) {
            // se il contenuto del file non è in formato json ricreo il file
            this.writeNewReportFile();
            System.err.println("Errore - questo file non contiene un JSON valido");
        }

    }

    /**
     * il metodo provvede alla formattazione e alla ricreazione del file nel caso in cui sia corrotto o non accessibile
     */
    private void writeNewReportFile() {
        try {
            FileWriter file = new FileWriter(this.path, false);

            City city = CityService.consumingApi(WeatherApplication.settings.city);
            JSONObject cityJson = city.exportJson();

            JSONArray arrayRilevamenti = new JSONArray();
            arrayRilevamenti.put(cityJson);

            JSONObject jsonRilevamenti = new JSONObject();
            jsonRilevamenti.put("rilevamenti", arrayRilevamenti);

            String stringRilevamenti = jsonRilevamenti.toString();

            file.write(stringRilevamenti);

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
