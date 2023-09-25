package org.example;

import com.google.gson.Gson;
import org.example.model.HumidityDTO;

import java.io.IOException;

public class WeatherAPIReader {

    public static HumidityDTO getCopenhagenHumidity() throws IOException{

        String weatherJSON = HttpUtils.fetchData("https://vejr.eu/api.php?location=K%C3%B8benhavn&degree=C");

        Gson gson = new Gson();

        return gson.fromJson(weatherJSON, HumidityDTO.class);

    }


}
