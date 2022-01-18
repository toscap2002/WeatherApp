package com.example.Weather.filtri;

import com.example.Weather.error.NotFoundException;
import com.example.Weather.model.City;
import com.example.Weather.service.CityServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class StatisticheDiff  {


    private Statistiche statistiche;

    public String compareStatic(){
        CityServiceImpl csi = new CityServiceImpl();

           try {
               City current = csi.consumingApi();
               City forecast = csi.apifivedays();
           }catch (NotFoundException e){
               throw new NotFoundException();
           }

        return String.valueOf(equals(statistiche));
    }








}
