package com.movies.demo.service;

import com.movies.demo.dao.MovieDao;
import com.movies.demo.model.MovieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    MovieDao movieDao;

    @Override
    @Transactional
    public MovieModel createMovie(MovieModel movie) {
        int result = movieDao.createMovie(movie);
        return movie;
    }

}
