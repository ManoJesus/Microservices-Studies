package com.github.manojesus.moviecatalogservice.resources;

import com.github.manojesus.moviecatalogservice.models.CatalogItem;
import com.github.manojesus.moviecatalogservice.models.Movie;
import com.github.manojesus.moviecatalogservice.models.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {

    final RestTemplate restTemplate;
    public MovieCatalogResources(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        // Use the rest template that is way to get data using rest methods, and get all the rating movies from a user
        UserRating userRatings = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/"+userId,UserRating.class);

        return userRatings.getUserRatings().stream().map(rating -> {
            //convert each rating into a movie info, accessing the movie-info-service and retrieving the data using movieId from the rating service
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
            //returning a movie catalog object with movie's rating and description, and mapping this into the ratings list
            return new CatalogItem(movie.getNameMovie(), movie.getMovieDescription(), rating.getRating());
        }).collect(Collectors.toList());

    }
}
