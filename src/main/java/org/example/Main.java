package org.example;

import org.example.config.ScrapeWeather;
import org.example.config.WeatherAPIReader;
import org.example.model.HumidityDTO;
import org.example.model.WeatherDTO;
import org.example.model.WeatherEntity;
import org.example.model.WeatherTodayEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        List<WeatherDTO> weatherDTOs = ScrapeWeather.scrapeVejreti();

        HumidityDTO humidityDTO = WeatherAPIReader.getHumidityQuality();

        WeatherTodayEntity weatherTodayEntity = new WeatherTodayEntity(weatherDTOs.get(0), humidityDTO);

        System.out.println(weatherTodayEntity);


    }
}