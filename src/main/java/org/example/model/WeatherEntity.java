package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private String rain;
    private String temp;
    private String skyText;
    private int humidity;
    private String windText;

    public WeatherEntity(WeatherDTO weatherDTO, HumidityDTO humidityDTO) {



    }
}
