### Weather App

We have created a weather app that takes data web scraping https://www.vejreti.com/europe/denmark?page=14 for data,
about weather in Denmark and casts it into dto's through loops, which persist forecast data for 14 days at a time.
The scraping is done with jsoup.

We then enrich the data with a response from several weather api's where we fetch points about the weather.

We store the data udsing JPA.

We test:

We use DTO's to represent the data.

[Github Repository link](https://github.com/pantertanter/SP-2-Data_Enrichment)

