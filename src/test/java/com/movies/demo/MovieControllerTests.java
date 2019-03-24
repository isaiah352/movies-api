package com.movies.demo;


import com.movies.demo.controller.MovieController;
import com.movies.demo.model.MovieModel;
import com.movies.demo.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieControllerTests {

    private MockMvc mockMvc;

    @Mock
    private MovieService mockMovieService;

    @InjectMocks
    private MovieController movieController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
    }

    @Test
    public void testListMovies() throws Exception {

        ArrayList<MovieModel> mockList = new ArrayList<>();
        MovieModel mockMovieModel = new MovieModel();
        mockMovieModel.setRating("PG");
        mockMovieModel.setYear("1987");
        mockMovieModel.setGenre("Fantasy/Romance");
        mockMovieModel.setName("The Princess Bride");
        mockList.add(mockMovieModel);

        Mockito.when(mockMovieService.getMovieList()).thenReturn(mockList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/movie/list").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());

    }


}
