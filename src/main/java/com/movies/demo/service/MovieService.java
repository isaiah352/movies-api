package com.movies.demo.service;

import com.movies.demo.model.MovieModel;
import com.movies.demo.model.MovieResponseModel;

import javax.xml.ws.WebServiceException;
import java.util.ArrayList;

public interface MovieService {

    MovieResponseModel putMovie(MovieModel movie) throws WebServiceException;
    MovieResponseModel deleteMovieByName(String name) throws WebServiceException;
    ArrayList<MovieModel> getMovieList() throws WebServiceException;
}
