package com.movies.demo.controller;

import com.movies.demo.model.TimeResponseModel;
import com.movies.demo.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/timeOfDay/")
public class TimeController {
    @Autowired
    TimeService timeService;

    @GetMapping
    public ResponseEntity<TimeResponseModel> getTime() {
        return new ResponseEntity<>(timeService.getTime(), HttpStatus.OK);
    }
}
