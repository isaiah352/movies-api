package com.movies.demo.service;

import com.movies.demo.common.Constants;
import com.movies.demo.dao.MovieDao;
import com.movies.demo.model.MovieModel;
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
    public String putMovie(MovieModel movie) {
        int result = 0;
        String responseMessage = Constants.TRANSACTION_FAILED;
        try {
            MovieModel existingMovie = movieDao.getMovieByName(movie.getName());
            if(existingMovie.getName() != null) {
                result = movieDao.updateMovie(movie);
                if(result > 0) {
                    responseMessage = Constants.UPDATE_SUCCEEDED;
                }
            } else {
                result = movieDao.createMovie(movie);
                if(result > 0) {
                    responseMessage = Constants.CREATE_SUCCEEDED;
                }
            }
        } catch(HttpServerErrorException.InternalServerError e) {
            System.out.println(PUT_MOVIE_EXCEPTION + e);
            return responseMessage;
        }
        return responseMessage;
    }

    @Override
    @Transactional
    public String deleteMovieByName(String name) {
        return movieDao.deleteMovieByName(name);
    }

    @Override
    @Transactional
    public ArrayList<MovieModel> getMovieList() {
        return movieDao.getMovieList();
    }

}
