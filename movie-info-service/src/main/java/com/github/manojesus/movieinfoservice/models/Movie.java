package com.github.manojesus.movieinfoservice.models;

public class Movie {
    private String movieId;
    private String nameMovie;
    private String movieDescription;

    public Movie() {    }

    public Movie(String movieId, String nameMovie, String movieDescription) {
        this.movieId = movieId;
        this.nameMovie = nameMovie;
        this.movieDescription = movieDescription;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }
}
