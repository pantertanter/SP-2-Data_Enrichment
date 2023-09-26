package org.example.config;

import org.example.model.WeatherDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScrapeWeatherTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void scrapeVejreti() throws IOException {
        List<WeatherDTO> weatherDTOList = ScrapeWeather.scrapeVejreti();
        assertEquals(14, weatherDTOList.size());
    }
}