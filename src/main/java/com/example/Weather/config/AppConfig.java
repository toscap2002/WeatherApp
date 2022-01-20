package com.example.Weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Pierro e Pelliccia
 * Definisce il RestTemplete @bean che viene @autowired
 */

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplete(){
        return new RestTemplate();
    }


}
