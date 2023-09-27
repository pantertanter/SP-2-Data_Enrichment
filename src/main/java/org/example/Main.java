package org.example;

import org.example.dao.WeatherDAO;
import org.example.utils.ScrapeWeather;
import org.example.utils.WeatherAPIReader;
import org.example.dto.HumidityDTO;
import org.example.dto.WeatherDTO;
import org.example.model.WeatherTodayEntity;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        List<WeatherDTO> weatherDTOs = ScrapeWeather.scrapeVejreti();

        weatherDTOs.forEach(System.out::println);

        HumidityDTO humidityDTO = WeatherAPIReader.getHumidityQuality();

        WeatherTodayEntity weatherTodayEntity = new WeatherTodayEntity(weatherDTOs.get(0), humidityDTO);

        System.out.println(weatherTodayEntity);




    }
}