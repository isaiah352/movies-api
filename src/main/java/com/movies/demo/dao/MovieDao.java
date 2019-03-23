package com.movies.demo.dao;

import com.movies.demo.model.MovieModel;
import org.springframework.dao.DataAccessException;

public interface MovieDao {
    int createMovie(MovieModel movie) throws DataAccessException;
}
