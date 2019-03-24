package com.movies.demo.controller;

import com.movies.demo.model.MovieModel;
import com.movies.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/movie/")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PutMapping
    public ResponseEntity<String> putMovie(@RequestBody @Validated MovieModel movie) throws RestClientException {
        return new ResponseEntity<>(movieService.putMovie(movie), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteMovie(@RequestParam String movieName) throws RestClientException {
        return new ResponseEntity<>(movieService.deleteMovieByName(movieName), HttpStatus.OK);
    }

    @RequestMapping(value = "list/", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<MovieModel>> listMovies() throws RestClientException {
        return new ResponseEntity<>(movieService.getMovieList(), HttpStatus.OK);
    }
}
