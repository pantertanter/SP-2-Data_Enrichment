package org.example.dao;

import org.example.config.HibernateConfig;
import org.example.config.ScrapeWeather;
import org.example.config.WeatherAPIReader;
import org.example.model.HumidityDTO;
import org.example.model.WeatherDTO;
import org.example.model.WeatherEntity;
import org.example.model.WeatherTodayEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDAOTest {

    private static WeatherDAO dao = WeatherDAO.getInstance(HibernateConfig.getEntityManagerFactoryConfig());



    @BeforeEach
    void setUp() throws IOException, InterruptedException {
        List<WeatherDTO> weatherDTOList = ScrapeWeather.scrapeVejreti();
        HumidityDTO humidityDTO = WeatherAPIReader.getHumidityQuality();

        WeatherTodayEntity weatherTodayEntity = new WeatherTodayEntity(weatherDTOList.get(0), humidityDTO);

        dao.createWeatherToday(weatherTodayEntity);

        weatherDTOList.forEach(weatherDTO -> {
            WeatherEntity weatherEntity = new WeatherEntity(weatherDTO);
            dao.createWeather(weatherEntity);
        });
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getInstance() {
    }

    @Test
    void getWeather() {
    }

    @Test
    void getAllWeather() {
    }

    @Test
    void updateWeather() {
    }

    @Test
    void deleteWeather() {
    }

    @Test
    void createWeather() {
    }

    @Test
    void createWeatherToday() {
    }

    @Test
    void updateWeatherToday() {
    }

    @Test
    void deleteWeatherToday() {
    }

    @Test
    void getWeatherToday() {
    }

}