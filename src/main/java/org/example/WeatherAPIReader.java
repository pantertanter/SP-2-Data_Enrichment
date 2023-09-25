package org.example;

import com.google.gson.Gson;
import org.example.model.HumidityDTO;
import org.example.model.QualityDTO;

import java.io.IOException;

public class WeatherAPIReader {

    public static String getHillerødQuality() throws IOException, InterruptedException {

        String weatherJSON = HttpUtils.fetchData();

        Gson gson = new Gson();

        return weatherJSON;

    }


}
