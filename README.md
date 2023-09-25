## Weather App

We have created a weather app that takes data web scraping https://www.vejreti.com/europe/denmark?page=14 which has data,
about weather in Denmark and casts it into a dto with a for loop for 14 days at a time.
The scraping is done with jsoup.

We then enrich the data with a response from a weather api where we fetch som more points about the weather.

We store the data in a with JPA.

We test:

We use DTO to represent the data.


