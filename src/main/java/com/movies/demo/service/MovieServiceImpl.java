package com.movies.demo.service;

import com.movies.demo.common.Constants;
import com.movies.demo.dao.MovieDao;
import com.movies.demo.model.MovieModel;
import com.movies.demo.model.MovieResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;

@Service
public class MovieServiceImpl implements MovieService{

    private static final String PUT_MOVIE_EXCEPTION = "Catching exception in MovieServiceImpl > putMovie(): ";

    @Autowired
    MovieDao movieDao;

    @Override
    @Transactional
    public MovieResponseModel putMovie(MovieModel movie) {
        int result = 0;
        MovieResponseModel message = new MovieResponseModel();
        message.setMessage(Constants.TRANSACTION_FAILED);
        try {
            MovieModel existingMovie = movieDao.getMovieByName(movie.getName());
            if(existingMovie.getName() != null) {
                result = movieDao.updateMovie(movie);
                if(result > 0) {
                    message.setMessage(Constants.UPDATE_SUCCEEDED);
                }
            } else {
                result = movieDao.createMovie(movie);
                if(result > 0) {
                    message.setMessage(Constants.CREATE_SUCCEEDED);
                }
            }
        } catch(HttpServerErrorException.InternalServerError e) {
            System.out.println(PUT_MOVIE_EXCEPTION + e);
            return message;
        }
        return message;
    }

    @Override
    @Transactional
    public MovieResponseModel deleteMovieByName(String name) {
        MovieResponseModel message = new MovieResponseModel();
        message.setMessage(movieDao.deleteMovieByName(name));
        return message;
    }

    @Override
    @Transactional
    public ArrayList<MovieModel> getMovieList() {
        return movieDao.getMovieList();
    }

}
