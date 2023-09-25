package org.example.model;


import lombok.ToString;

import java.time.LocalDate;

@ToString
public class WeatherDTO {

    private String day;
    private String date;
    private String rain;
    private String temp;

    public WeatherDTO(String day, String date, String rain, String temp) {
        this.day = day;
        this.date = date;
        this.rain = rain;
        this.temp = temp;
    }
}
