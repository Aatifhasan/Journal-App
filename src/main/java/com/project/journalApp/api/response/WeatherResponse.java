package com.project.journalApp.api.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherResponse {

    private Current current;

    @Getter
    @Setter
    public class Current{


        private int temperature;
        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;

        private int feelslike;
        private String isDay;
    }

//    public class Location{
//        private String name;
//        private String country;
//        private String region;
//        private String lat;
//        private String lon;
//        private String timezoneId;
//        private String localtime;
//        private int localtimeEpoch;
//        private String utcOffset;
//    }

//    public class Request{
//        private String type;
//        private String query;
//        private String language;
//        private String unit;
//    }



}
