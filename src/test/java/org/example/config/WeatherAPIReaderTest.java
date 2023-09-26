package org.example.config;

import org.example.dto.HumidityDTO;
import org.example.utils.WeatherAPIReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WeatherAPIReaderTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getHumidityQuality() throws IOException, InterruptedException {
        HumidityDTO humidityDTO = WeatherAPIReader.getHumidityQuality();
        assertNotNull(humidityDTO);
    }
}