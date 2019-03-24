package com.movies.demo.controller;

import com.movies.demo.model.MovieModel;
import com.movies.demo.model.MovieResponseModel;
import com.movies.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    // This endpoint serves to create when a record is new, and update when it exists. It is exposed through both /create and /update.
    @RequestMapping(value = {"/create", "/update"}, method = RequestMethod.PUT)
    public ResponseEntity<MovieResponseModel> putMovie(@RequestBody @Validated MovieModel movie) throws RestClientException {
        return new ResponseEntity<>(movieService.putMovie(movie), HttpStatus.OK);
    }

    /*Did not include the @Validated annotation with this one, since the name is the only value we require from the json object to find a unique movie to delete
      other values do not have to be provided in this case.*/
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<MovieResponseModel> deleteMovie(@RequestBody MovieModel movie) throws RestClientException {
        return new ResponseEntity<>(movieService.deleteMovieByName(movie.getName()), HttpStatus.OK);
    }

    // Returns all existing movies.
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<MovieModel>> listMovies() throws RestClientException {
        return new ResponseEntity<>(movieService.getMovieList(), HttpStatus.OK);
    }
}
