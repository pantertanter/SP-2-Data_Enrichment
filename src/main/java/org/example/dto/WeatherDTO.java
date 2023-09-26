package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
public class WeatherDTO {

    private String day;
    private String date;
    private String rain;
    private String temp;

}
