package com.movies.demo.model;

import com.movies.demo.common.Constants;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class MovieModel implements Serializable {

    @NotNull(message = Constants.NAME_NULL_VALIDATION_MESSAGE)
    @Size(min=1, max = 255, message = Constants.NAME_SIZE_VALIDATION_MESSAGE)
    private String name;
    @NotNull(message = Constants.GENRE_NULL_VALIDATION_MESSAGE)
    @Size(min=1, max = 255, message = Constants.GENRE_SIZE_VALIDATION_MESSAGE)
    private String genre;
    @NotNull(message = Constants.YEAR_NULL_VALIDATION_MESSAGE)
    @Size(min=4, max = 4, message = Constants.YEAR_SIZE_VALIDATION_MESSAGE)
    private String year;
    @NotNull(message = Constants.RATING_NULL_VALIDATION_MESSAGE)
    @Size(min=1, max = 10, message = Constants.RATING_SIZE_VALIDATION_MESSAGE)
    private String rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
