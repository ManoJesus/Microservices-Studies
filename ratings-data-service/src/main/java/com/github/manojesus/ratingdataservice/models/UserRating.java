package com.github.manojesus.ratingdataservice.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserRating {
    private String userId;
    private List<Rating> userRatings = new LinkedList<>();

    public UserRating(String userId,List<Rating> userRatings) {
        this.userId = userId;
        this.userRatings = userRatings;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }
}
