package com.example.Weather.filtri;

import com.example.Weather.model.City;
import com.example.Weather.model.Main;
import com.example.Weather.model.Weather;
import com.example.Weather.service.CityServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import net.minidev.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@Service
public class StatisticheDiff  {
    JsonNode list;
    JsonNode city;

    private Statistiche statistiche;

    public String compareStatic() throws JsonProcessingException {
        CityServiceImpl csi = new CityServiceImpl();
        List<City> current = Arrays.asList(csi.consumingApi());
        List forecast = Arrays.asList(csi.apifivedays());

        System.out.println(current);
        System.out.println(forecast);

        assertEquals(current, forecast);


        /*JSON(current) == JSON.stringify(forecast)


        _.isEqual(object1, object2)*/


        /*current = current.map((val,index)=>val.household_name)

        b= b.elements.map((val,index)=>val.householdname)

        console.log(a,b)

        console.log(_.isEqual(a,b))

        TypeReference<Map<String, Object>> type = new TypeReference<Map<String, Object>>() {};

        Map<String, Object> leftMap = toJson(current);
        Map<String, Object> rightMap = toJson(forecast);

        MapDifference<String, Object> difference = Maps.difference(current, forecast);
        printMapDifference(difference);*/
        /*CityServiceImpl csi = new CityServiceImpl();

           try {
               City current = csi.consumingApi();
               City forecast = csi.apifivedays();
           }catch (NotFoundException e){
               throw new NotFoundException();
           }

        return String.valueOf(equals(statistiche));

        *//*City current = csi.consumingApi();
        City forecast = csi.apifivedays();*//*

        city = ObjectMapper.;
        list = objectMapper.readTree(list.toString());

        System.out.println(list.equals(city));*/
        return null;
    }

    private Map<String, Object> toJson(List<City> current) {

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

        }


    /*private static void printMapDifference(String difference) {
        System.out.println("\n\nEntries only on left\n--------------------------");
        difference.equalsIgnoreCase(value -> System.out.println(value));

        System.out.println("\n\nEntries only on right\n--------------------------");
        difference.entriesOnlyOnRight().forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("\n\nEntries differing\n--------------------------");
        difference.entriesDiffering().forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("\n\nEntries in common\n--------------------------");
        difference.entriesInCommon().forEach((key, value) -> System.out.println(key + ": " + value));
    }*/


}
