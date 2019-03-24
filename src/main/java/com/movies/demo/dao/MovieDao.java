package com.movies.demo.dao;

import com.movies.demo.model.MovieModel;
import org.springframework.dao.DataAccessException;
import java.util.ArrayList;

public interface MovieDao {
    int createMovie(MovieModel movie) throws DataAccessException;
    int updateMovie(MovieModel movie) throws DataAccessException;
    MovieModel getMovieByName(String name) throws DataAccessException;
    int deleteMovieByName(String name) throws DataAccessException;
    ArrayList<MovieModel> getMovieList() throws DataAccessException;
}
