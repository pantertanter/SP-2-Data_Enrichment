package org.example.dao;

import org.example.config.HibernateConfig;
import org.example.utils.ScrapeWeather;
import org.example.utils.WeatherAPIReader;
import org.example.dto.HumidityDTO;
import org.example.dto.WeatherDTO;
import org.example.model.WeatherEntity;
import org.example.model.WeatherTodayEntity;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDAOTest {

    private static WeatherDAO dao = WeatherDAO.getInstance(HibernateConfig.getEntityManagerFactoryConfig());



    @BeforeAll
    static void setUp() throws IOException, InterruptedException {
//        List<WeatherDTO> weatherDTOList = ScrapeWeather.scrapeVejreti();
        HumidityDTO humidityDTO = WeatherAPIReader.getHumidityQuality();

        List<WeatherDTO> weatherDTOList = new ArrayList<>();
        weatherDTOList.add(new WeatherDTO("Onsdag", "27. sep", "0 mm", "20/15"));
        weatherDTOList.add(new WeatherDTO("Torsdag", "28. sep", "0,5 mm", "18/14"));
        weatherDTOList.add(new WeatherDTO("Fredag", "29. sep", "1 mm", "18/14"));
        weatherDTOList.add(new WeatherDTO("Lørdag", "30. sep", "0 mm", "17/13"));
        weatherDTOList.add(new WeatherDTO("Søndag", "1. okt", "0 mm", "16/13"));
        weatherDTOList.add(new WeatherDTO("Mandag", "2. okt", "0,3 mm", "17/13"));
        weatherDTOList.add(new WeatherDTO("Tirsdag", "3. okt", "2 mm", "15/12"));
        weatherDTOList.add(new WeatherDTO("Onsdag", "4. okt", "3,8 mm", "16/14"));
        weatherDTOList.add(new WeatherDTO("Torsdag", "5. okt", "0 mm", "15/12"));
        weatherDTOList.add(new WeatherDTO("Fredag", "6. okt", "0 mm", "12/11"));
        weatherDTOList.add(new WeatherDTO("Lørdag", "7. okt", "0 mm", "14/10"));
        weatherDTOList.add(new WeatherDTO("Søndag", "8. okt", "0 mm", "13/9"));
        weatherDTOList.add(new WeatherDTO("Mandag", "9. okt", "0 mm", "11/8"));

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
        assertEquals(dao.getAllWeather().size(), 13);
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
        assertEquals(dao.getWeather(14).getTemp(), "100");
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

    @Disabled
    @Test
    void allWeatherSortedByTemp() {
        assertEquals(dao.allWeatherSortedByTemp().size(), 13);
    }
}