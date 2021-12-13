package com.github.manojesus.moviecatalogservice.resources;

import com.github.manojesus.moviecatalogservice.models.CatalogItem;
import com.github.manojesus.moviecatalogservice.models.UserRating;
import com.github.manojesus.moviecatalogservice.services.MovieInfoService;
import com.github.manojesus.moviecatalogservice.services.UserRatingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {

    private final UserRatingService userRatingService;
    private final MovieInfoService movieInfoService;

    public MovieCatalogResources(UserRatingService userRatingService, MovieInfoService movieInfoService) {

        this.userRatingService = userRatingService;
        this.movieInfoService = movieInfoService;
    }

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        // Use the rest template that is way to get data using rest methods, and get all the rating movies from a user
        UserRating userRatings = userRatingService.getUserRatings(userId);

        return userRatings.getUserRatings().stream().map(movieInfoService::getCatalogItem).collect(Collectors.toList());
    }



}
