package com.github.manojesus.moviecatalogservice.models;

import java.util.LinkedList;
import java.util.List;

public class UserRating {
    private List<Rating> userRatings = new LinkedList<>();

    public UserRating() {    }

    public UserRating(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }

    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }
}
