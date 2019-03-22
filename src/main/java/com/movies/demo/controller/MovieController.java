package com.movies.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie/")
public class MovieController {
    @GetMapping
    private String hello() {
        return "hello world";
    }
}
