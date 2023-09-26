package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class WeatherTodayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date = LocalDate.now();
    private String rain;
    private String temp;
    private String skyText;
    private int humidity;
    private String windText;

    public WeatherTodayEntity(WeatherDTO weatherDTO, HumidityDTO humidityDTO) {
        this.rain = weatherDTO.getRain();
        this.temp = weatherDTO.getTemp();
        this.skyText = humidityDTO.getCurrentData().getSkyText();
        this.humidity = humidityDTO.getCurrentData().getHumidity();
        this.windText = humidityDTO.getCurrentData().getWindText();
    }


}
