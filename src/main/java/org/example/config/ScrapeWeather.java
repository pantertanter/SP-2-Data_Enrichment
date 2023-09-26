package org.example.config;

import org.example.model.WeatherDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScrapeWeather {

    public static void main(String[] args) throws IOException {
        scrapeVejreti();
    }

    public static List<WeatherDTO> scrapeVejreti() throws IOException {
        String url = "https://www.vejreti.com/europe/denmark?page=14";

        Document doc = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                                "AppleWebKit/537.36 (KHTML, like Gecko) " +
                                "Chrome/91.0.4472.124 Safari/537.36")
//                        .referrer("https://www.google.com/")
                .header("accept", "text/html,application/xhtml+xml;charset=UTF-8")
                                .get();

        System.out.println(doc);

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

        return dtos;
    }
}
