package com.github.manojesus.moviecatalogservice.services;

import com.github.manojesus.moviecatalogservice.models.CatalogItem;
import com.github.manojesus.moviecatalogservice.models.Movie;
import com.github.manojesus.moviecatalogservice.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {

    private final RestTemplate restTemplate;

    public MovieInfoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        //convert each rating into a movie info, accessing the movie-info-service and retrieving the data using movieId from the rating service
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
        //returning a movie catalog object with movie's rating and description, and mapping this into the ratings list
        return new CatalogItem(movie.getNameMovie(), movie.getMovieDescription(), rating.getRating());
    }


    public CatalogItem getFallbackCatalogItem(Rating rating) {
        return new CatalogItem("none","none", rating.getRating());
    }
}
