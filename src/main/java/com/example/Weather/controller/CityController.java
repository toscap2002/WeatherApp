package com.example.Weather.controller;

import com.example.Weather.model.City;
import com.example.Weather.model.Lista;
import com.example.Weather.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CityController {

    CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/city")
    public ResponseEntity<City> getCity(){
        return new ResponseEntity<>(cityService.consumingApi(), HttpStatus.OK);
    }

    @GetMapping("/forecast")
    public ResponseEntity<Lista> getCityForecast(){
        return new ResponseEntity<>(cityService.apifivedays(), HttpStatus.OK);
    }

    @GetMapping("/saveEveryHour")
    public ResponseEntity<Object> getEveryHour(){
        return new ResponseEntity<>(cityService.saveHour(), HttpStatus.OK);
    }

    @GetMapping("/saveDay")
    public ResponseEntity<Object> getDay(){
        return new ResponseEntity<>(cityService.saveDay(), HttpStatus.OK);
    }

    /*@GetMapping("/weather")
    public ResponseEntity<Object> getMain(){
        return new ResponseEntity<>(cityService.getCityWeather(), HttpStatus.OK);
    }*/



    /*@GetMapping("/cityweather")
    public ResponseEntity<Object> getMain(@RequestParam(value = "cityName" ,defaultValue = "Ancona") String cityName) throws Exception {
      try{
          City city = cityService.getCityWeather();
          cityService.forecast(cityName);
          return new ResponseEntity<>(cityService.readfromjson(), HttpStatus.OK);
      }catch(NotFoundException e){
         return new ResponseEntity<>(cityName, HttpStatus.NOT_FOUND);
      }

    }*/


    /* private static final String MAIN_PAGE = "main";
    private static final String url = "https://api.openweathermap.org/data/2.5/weather?q=Ancona&appid=";
    private static final String api_key = "711b077df0c4631f345bd97cfb63616a";
*/
/*

    @Autowired
    private ServiceWeather serviceWeather;

    @GetMapping("/weather")
    public String main(final Model model){
        List<Weather> weather = (List<Weather>) serviceWeather.parse(url);
        model.addAttribute("city", weather.get(0));
        return MAIN_PAGE+api_key;
    }
*/





  /*@RequestMapping(value = "/weather", method = RequestMethod.GET)
    public ResponseEntity<Object> getCity(){
        return new ResponseEntity<>(cityService.getWeatherfromApi("Ancona", nuvoloso), HttpStatus.OK);
    }


    @GetMapping("/weather/{city_w}")
    public @ResponseBody
    String getMain(Weather city_w){
       String weather = null;
       if(city_w==null){
           weather=city_w.getName();
       }
        return weather;
    }
*/
   /* @RequestMapping(value = "/weather/{id}", method = RequestMethod.POST)
    public ResponseEntity<Object> getWeatherfromApi(@RequestBody Weather weather){
        cityService.getWeatherfromApi((weather));
        return new ResponseEntity<>("City is created successfully", HttpStatus.OK);
    }*/


   /* @RequestMapping(value = "/weather/{city}", method = RequestMethod.PUT)
    public ResponseEntity<Object> getCityWeather(@PathVariable("city") String city, @RequestBody  Weather weather){
       cityService.getCityWeather();
       return new ResponseEntity<Object>(cityService.getWeather(), HttpStatus.OK);

    }*/

  /*  @GetMapping(value = "/weather")
    public @ResponseBody
    CityServiceImpl getCityWeather(){
        cityService.getWeather();
        return (CityServiceImpl) cityService;
    }
*/


   /* @RequestMapping(
            value = "/city",
            method = RequestMethod.GET)
    public ResponseEntity<String> forecast(@RequestParam String cityname) throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(cityService.forecast(cityname).toString(), HttpStatus.OK);
    }*/

    /*@GetMapping(path = "/weather")
    public ResponseEntity<Object> getMain() throws Exception {
        return new ResponseEntity<>(cityService.toString(),HttpStatus.OK);
    }*/
  /*@RequestMapping(value = "main")
    public ResponseEntity<Object> getWeather(@RequestParam Weather cityName) {
        return new ResponseEntity<>(cityService.getCity(cityName).toString(), HttpStatus.OK);
    }*/

    /*public ServiceJson serviceJson = new ServiceJson();
    public City city;*/




    /*@PostMapping
    public void searchCity(@RequestBody City city) {
        System.out.println(city);
    }*/
}
