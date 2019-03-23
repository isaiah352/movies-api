package com.movies.demo.dao;

import com.movies.demo.model.MovieModel;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDAOImpl implements MovieDao{

    private NamedParameterJdbcTemplate jdbc;

    public MovieDAOImpl(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public int createMovie(MovieModel movie) {
        final String INSERT_SQL = "INSERT INTO movie (name, genre, year_released, rating, last_updated_date, created_date) " +
                "VALUES (:name, :genre, :year, :rating, SYSTIMESTAMP, SYSTIMESTAMP)";
        return jdbc.update(INSERT_SQL, new BeanPropertySqlParameterSource(movie));
    }

}
