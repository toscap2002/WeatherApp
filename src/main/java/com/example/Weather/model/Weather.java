package com.example.Weather.model;

/**
 * Questa classe indica il main e l'id di una città
 * @author Pierro e Pelliccia
 */

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

    @Override
    public String toString(){

        return"Id: " + id +", \nmain: " + main;
    }

}
