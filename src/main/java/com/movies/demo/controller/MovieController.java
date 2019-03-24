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
// I made the routing "movie" in accordance with the assignments requirements, however, REST best practices would stipulate that this should be the plural "movies".
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    /*This endpoint is stuck in between being a use case for POST and PUT
      In accordance with the requirements, the URI of this endpoint does not contain an id as a URI param which makes it more like POST
      However, I designed this endpoint to be idempotent like a PUT should be
      I compromised by making this a PUT as is, and under different circumstances would include the movie id as a URI param to make this usage of PUT more restful*/
    @RequestMapping(value = {"/create", "/update"}, method = RequestMethod.PUT)
    public ResponseEntity<MovieResponseModel> putMovie(@RequestBody @Validated MovieModel movie) throws RestClientException {
        return new ResponseEntity<>(movieService.putMovie(movie), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<MovieResponseModel> deleteMovie(@RequestBody MovieModel movie) throws RestClientException {
        return new ResponseEntity<>(movieService.deleteMovieByName(movie.getName()), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<MovieModel>> listMovies() throws RestClientException {
        return new ResponseEntity<>(movieService.getMovieList(), HttpStatus.OK);
    }
}
