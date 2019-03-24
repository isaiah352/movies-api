package com.movies.demo.service;

import com.movies.demo.model.MovieModel;
import javax.xml.ws.WebServiceException;
import java.util.ArrayList;

public interface MovieService {

    String putMovie(MovieModel movie) throws WebServiceException;
    String deleteMovieByName(String name) throws WebServiceException;
    ArrayList<MovieModel> getMovieList() throws WebServiceException;
}
