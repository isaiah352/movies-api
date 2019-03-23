package com.movies.demo.controller;

import com.movies.demo.model.MovieModel;
import com.movies.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

@RestController
@RequestMapping("/api/movie/")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    private String hello() {
        return "hello world";
    }
    @PutMapping
    private ResponseEntity<MovieModel> putMovie(@RequestBody MovieModel movie) throws RestClientException {
        movie = movieService.createMovie(movie);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }
}
