package com.project.journalApp.service;

import com.project.journalApp.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;
    @Value("${weather.api.url}")
    private String API;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RedisService redisService;



    public WeatherResponse getWeather(String city) {
        WeatherResponse weatherResponse = redisService.get("weather_of_" + city, WeatherResponse.class);
        if(weatherResponse!=null){
            return weatherResponse;
        }
        else {
            String url = API.replace("CITY", city).replace("apiKey", apiKey);

            ResponseEntity<WeatherResponse> response = restTemplate.exchange(url, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if(body!=null){
                redisService.set("weather_of_" + city, body, 300l);
            }
            return body;
        }
    }
}
