package org.example;

import org.example.model.WeatherDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String url = "https://www.vejreti.com/europe/denmark?page=14";

        Document doc = Jsoup.connect(url).get();

        Elements elements = doc.select(".weather_day_box");

        List<WeatherDTO> dtos = new ArrayList<>();


        for(Element e : elements){
            if(e.select(".weather_day_date").isEmpty()){
                break;
            }
            String day = e.select(".weather_day_date").text();
            String date = e.select(".weather_date_month").text();
            String rain = e.select(".weather_day_mm").text();
            String temp = e.select(".fourteen_day_wrap").text();

            dtos.add(new WeatherDTO(day,date,rain, temp));

        }

        dtos.forEach(System.out::println);


    }
}