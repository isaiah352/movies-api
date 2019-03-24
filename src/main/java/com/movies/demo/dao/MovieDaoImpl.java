package com.movies.demo.dao;

import com.movies.demo.common.Constants;
import com.movies.demo.model.MovieModel;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MovieDaoImpl implements MovieDao{

    private NamedParameterJdbcTemplate jdbc;

    public MovieDaoImpl(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public String deleteMovieByName(String name) {
        String retVal = "";
        final String DELETE_SQL = "DELETE FROM movie WHERE name = :name";
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        int result = 0;
        result = jdbc.update(DELETE_SQL, params);
        if(result > 0) {
            retVal = Constants.RECORD_DELETED_SUCCESSFULLY;
        } else {
            retVal = Constants.RECORD_NOT_FOUND;
        }
        return retVal;
    }

    @Override
    public int createMovie(MovieModel movie) {
        final String INSERT_SQL = "INSERT INTO movie (name, genre, year_released, rating, last_updated_date, created_date) " +
                "VALUES (:name, :genre, :year, :rating, :lastUpdated, :created)";
        Map<String, Object> params = new HashMap<>();
        params.put("genre", movie.getGenre());
        params.put("name", movie.getName());
        params.put("year", movie.getYear());
        params.put("rating", movie.getRating());
        params.put("lastUpdated", new Date());
        params.put("created", new Date());
        return jdbc.update(INSERT_SQL, params);
    }

    @Override
    public MovieModel getMovieByName(String name) {
        MovieModel movie = new MovieModel();
        final String FETCH_BY_NAME_SQL = "SELECT name, genre, year_released, rating FROM movie WHERE name = :name";
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        SqlRowSet rs = jdbc.queryForRowSet(FETCH_BY_NAME_SQL, params);
        while(rs.next()) {
            movie.setName(rs.getString("name"));
            movie.setGenre(rs.getString("genre"));
            movie.setRating(rs.getString("rating"));
            movie.setYear(rs.getString("year_released"));
        }
        return movie;
    }

    @Override
    public int updateMovie(MovieModel movie) {
        final String UPDATE_SQL = "UPDATE movie SET genre = :genre, year_released = :year, rating = :rating, last_updated_date = :lastUpdated " +
                                    "WHERE name = :name";
        Map<String, Object> params = new HashMap<>();
        params.put("name", movie.getName());
        params.put("genre", movie.getGenre());
        params.put("year", movie.getYear());
        params.put("rating", movie.getRating());
        params.put("lastUpdated", new Date());
        return jdbc.update(UPDATE_SQL, params);
    }

    @Override
    public ArrayList<MovieModel> getMovieList() {
        ArrayList<MovieModel> movieList = new ArrayList<>();
        final String FETCH_LIST_SQL = "SELECT * FROM movie";
        Map<String, Object> params = new HashMap<>();
        SqlRowSet rs = jdbc.queryForRowSet(FETCH_LIST_SQL, params);
        while(rs.next()) {
            MovieModel movie = new MovieModel();
            movie.setName(rs.getString("name"));
            movie.setGenre(rs.getString("genre"));
            movie.setRating(rs.getString("rating"));
            movie.setYear(rs.getString("year_released"));
            movieList.add(movie);
        }
        return movieList;
    }
}
