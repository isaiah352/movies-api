package com.movies.demo.controller;

import com.movies.demo.model.TimeResponseModel;
import com.movies.demo.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;


@RestController
@RequestMapping("/api/timeOfDay")
public class TimeController {
    @Autowired
    TimeService timeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<TimeResponseModel> getTime() throws RestClientException {
        return new ResponseEntity<>(timeService.getTime(), HttpStatus.OK);
    }
}
