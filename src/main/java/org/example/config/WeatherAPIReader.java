package org.example.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.config.HttpUtils;
import org.example.model.HumidityDTO;

import java.io.IOException;

public class WeatherAPIReader {


    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();


    public static HumidityDTO getHumidityQuality() throws IOException, InterruptedException {

        String weatherJSON = HttpUtils.fetchData("https://vejr.eu/api.php?location=K%C3%B8benhavn&degree=C");

        return gson.fromJson(weatherJSON, HumidityDTO.class);

    }


}
