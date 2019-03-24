package com.movies.demo;

import com.movies.demo.common.Constants;
import com.movies.demo.model.MovieModel;
import com.movies.demo.model.MovieResponseModel;
import com.movies.demo.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTests {
    @Autowired
    MovieService movieService;

    private MockMvc mockMvc;


    @Test
    public void putMovieTest() {
        MovieModel movieModel = new MovieModel();
        movieModel.setRating("PG");
        movieModel.setYear("1987");
        movieModel.setGenre("Fantasy/Romance");
        movieModel.setName("The Princess Bride");
        MovieResponseModel movieResponseModel;
        movieResponseModel = movieService.putMovie(movieModel);
        assertTrue(movieResponseModel.getMessage().equals(Constants.CREATE_SUCCEEDED));

        movieModel = new MovieModel();
        movieModel.setRating("PG");
        movieModel.setYear("1986");
        movieModel.setGenre("Fantasy/Romance");
        movieModel.setName("The Princess Bride");
        movieResponseModel = movieService.putMovie(movieModel);
        assertTrue(movieResponseModel.getMessage().equals(Constants.UPDATE_SUCCEEDED));
    }

    @Test
    public void getMovieListTest() {
        ArrayList<MovieModel> movieList = movieService.getMovieList();
        assertTrue(movieList.size() > 0);
    }

    @Test
    public void deleteMovieTest() {
        String movieName = "Top Gun";
        MovieResponseModel movieResponseModel;
        movieResponseModel = movieService.deleteMovieByName(movieName);
        assertTrue(movieResponseModel.getMessage().equals(Constants.RECORD_DELETED_SUCCESSFULLY));

        movieName = "This Movie Does Not Exist";
        movieResponseModel = movieService.deleteMovieByName(movieName);
        assertTrue(movieResponseModel.getMessage().equals(Constants.RECORD_NOT_FOUND));
    }

}
