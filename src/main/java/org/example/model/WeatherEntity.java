package org.example.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "weather")
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;
    private String rain;
    private String temp;

    public WeatherEntity(WeatherDTO weatherDTO) {
        String dayOfMonth = weatherDTO.getDate().substring(0,weatherDTO.getDate().length()-3);
        dayOfMonth.replace(".","");
        int dayOfMonthInt = Integer.parseInt(dayOfMonth);

        String month = weatherDTO.getDate().substring(weatherDTO.getDate().length()-3);
        int monthInt = 0;
        switch (month) {
            case "jan":
                monthInt = 1;
                break;
            case "feb":
                monthInt = 2;
                break;
            case "mar":
                monthInt = 3;
                break;
            case "apr":
                monthInt = 4;
                break;
            case "maj":
                monthInt = 5;
                break;
            case "jun":
                monthInt = 6;
                break;
            case "jul":
                monthInt = 7;
                break;
            case "aug":
                monthInt = 8;
                break;
            case "sep":
                monthInt = 9;
                break;
            case "okt":
                monthInt = 10;
                break;
            case "nov":
                monthInt = 11;
                break;
            case "dec":
                monthInt = 12;
                break;
            default:
                month = "00";
                break;
        }


        this.date = LocalDate.of(LocalDate.now().getYear(),monthInt,dayOfMonthInt);
        this.rain = weatherDTO.getRain();
        this.temp = weatherDTO.getTemp();
    }
}

// convert String day and date into LocalDate date




