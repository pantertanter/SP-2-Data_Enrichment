package org.example.dao;

import org.example.config.HibernateConfig;
import org.example.utils.ScrapeWeather;
import org.example.utils.WeatherAPIReader;
import org.example.dto.HumidityDTO;
import org.example.dto.WeatherDTO;
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
        assertNotNull(dao.getWeather(1));
    }

    @Test
    void getAllWeather() {
        assertEquals(dao.getAllWeather().size(), 14);
    }

    @Test
    void updateWeather() {
        WeatherEntity weatherEntity = dao.getWeather(1);
        weatherEntity.setTemp("100");
        dao.updateWeather(weatherEntity);
        assertEquals(dao.getWeather(1).getTemp(), "100");
    }

    @Test
    void deleteWeather() {
        dao.deleteWeather(1);
        assertNull(dao.getWeather(1));
    }

    @Test
    void createWeather() {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setTemp("100");
        dao.createWeather(weatherEntity);
        assertEquals(dao.getWeather(15).getTemp(), "100");
    }

    @Test
    void createWeatherToday() {
        WeatherTodayEntity wte = new WeatherTodayEntity();
        wte.setTemp("100");
        dao.createWeatherToday(wte);
        assertEquals(dao.getWeatherToday(2).getTemp(), "100");
    }

    @Test
    void updateWeatherToday() {
        WeatherTodayEntity wte = dao.getWeatherToday(1);
        wte.setTemp("100");
        dao.updateWeatherToday(wte);
        assertEquals(dao.getWeatherToday(1).getTemp(), "100");
    }

    @Test
    void deleteWeatherToday() {
        dao.deleteWeatherToday(1);
        assertNull(dao.getWeatherToday(1));
    }

    @Test
    void getWeatherToday() {
        assertNotNull(dao.getWeatherToday(1));
    }

}