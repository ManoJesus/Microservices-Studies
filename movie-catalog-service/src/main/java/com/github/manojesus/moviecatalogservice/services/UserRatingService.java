package com.github.manojesus.moviecatalogservice.services;

import com.github.manojesus.moviecatalogservice.models.Rating;
import com.github.manojesus.moviecatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserRatingService {

    private final RestTemplate restTemplate;

    public UserRatingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getFallbackUserRatings")
    public UserRating getUserRatings(String userId) {
        return restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" + userId, UserRating.class);
    }
    public UserRating getFallbackUserRatings(String userId) {
        return new UserRating(userId,
                List.of(new Rating(userId, 0))
        );
    }
}
