package com.github.manojesus.moviecatalogservice.models;


public class CatalogItem {
    private String nameOfMovie;
    private String descriptionOfMovie;
    private int userRatingOfMovie;

    public CatalogItem(String nameOfMovie, String descriptionOfMovie, int userRatingOfMovie) {
        this.nameOfMovie = nameOfMovie;
        this.descriptionOfMovie = descriptionOfMovie;
        this.userRatingOfMovie = userRatingOfMovie;
    }

    public String getNameOfMovie() {
        return nameOfMovie;
    }

    public void setName(String name) {
        this.nameOfMovie = name;
    }

    public String getDescriptionOfMovie() {
        return descriptionOfMovie;
    }

    public void setDescriptionOfMovie(String descriptionOfMovie) {
        this.descriptionOfMovie = descriptionOfMovie;
    }

    public int getUserRatingOfMovie() {
        return userRatingOfMovie;
    }

    public void setUserRatingOfMovie(int userRatingOfMovie) {
        this.userRatingOfMovie = userRatingOfMovie;
    }
}
