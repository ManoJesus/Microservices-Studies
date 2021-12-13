package com.github.manojesus.movieinfoservice.resources;

import com.github.manojesus.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
        return new Movie(movieId,"Impossible Mission", "Tom cruise gets crazy trying a mission that at first seems impossible");
    }
}
