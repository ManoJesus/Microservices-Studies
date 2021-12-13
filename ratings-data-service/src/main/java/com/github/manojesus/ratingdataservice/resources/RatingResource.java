package com.github.manojesus.ratingdataservice.resources;

import com.github.manojesus.ratingdataservice.models.Rating;
import com.github.manojesus.ratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

    @GetMapping("/{movieId}")
    public Rating getMovieRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,5);
    }

    @GetMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable String userId){
        return new UserRating(
                userId,
                new ArrayList<>(
                List.of(
                new Rating("12",4),
                new Rating("550",1)
        )));
    }
}
