### Weather App

We have created a weather app that takes data web scraping https://www.vejreti.com/europe/denmark?page=14 for data,
about the weather in Denmark and casts it into dto's and entities through loops, which persist of forecast data for 14 days at a time.
The scraping is done with jsoup library.

We then enrich the data with a response from a weather api where we fetch points about the weather.

We store the data in two tables with JPA technology. A table for the forecast for today and a table for the forecast for the next 14 days.

We have made a dao layer that handles the data and a service layer that handles the logic, like CRUD operations.

We test all methods: scraping, fetching and dao.

The site we scrape has blocked our ip though.

[Github Repository link](https://github.com/pantertanter/SP-2-Data_Enrichment)

[Site we scrape](https://www.vejreti.com/europe/denmark?page=14)

[API for enrichment](https://vejr.eu/api.php?location=K%C3%B8benhavn&degree=C)

![alt text](https://static1.bigstockphoto.com/8/6/3/large1500/368552620.jpg)

