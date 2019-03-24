package com.movies.demo;

import com.movies.demo.model.TimeResponseModel;
import com.movies.demo.service.TimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeServiceTests {
    @Autowired
    TimeService timeService;

    @Test
    public void getTimeTest() {
        TimeResponseModel timeResponseModel = timeService.getTime();
        assertTrue(timeResponseModel.getTime().length() > 0);
    }
}
