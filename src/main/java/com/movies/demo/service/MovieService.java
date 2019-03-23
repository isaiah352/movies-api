package com.movies.demo.service;

import com.movies.demo.model.MovieModel;
import org.springframework.stereotype.Service;

import javax.xml.ws.WebServiceException;

public interface MovieService {

    MovieModel createMovie(MovieModel movie) throws WebServiceException;

}
