package com.example.Weather.model;

public class Main  {
    private double temp;
    private double feels_like;
    private double temp_max;
    private double temp_min;
    private double temp_avg;
    private double variance;

    public Main(){}

   public Main(double temp, double feels_like, double temp_max, double temp_min, double temp_avg, double variance) {
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.temp_avg = temp_avg;
        this.variance = variance;
    }


    public double getTemp() {
        return temp;
    }
    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public double getTemp_max() {
        return temp_max;
    }
    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getTemp_min() {
        return temp_min;
    }
    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_avg() {
        return (temp_max+temp_min)/2;
    }
    public void setTemp_avg(double temp_avg) {
        this.temp_avg = (temp_max+temp_min)/2;
    }

    public double getVariance() {
        return (Math.pow(temp+temp_max+temp_min, 2))/3;
    }

    public void setVariance(double variance) {
        this.variance = (Math.pow(temp+temp_max+temp_min, 2))/3;
    }

    @Override
    public String toString(){

        return "\nTemperature{ " +
                "\ntemp: " + temp + "k" +
                "\n feels_like: " + feels_like +
                "\n temp_max: " + temp_max + "k" +
                "\n temp_min: " + temp_min + "k" +
                "\n temp_avg: " + temp_avg + "k" +
                "\n temp_var: " + variance + "k" +
                "}";
    }

}
