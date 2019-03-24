package com.movies.demo.model;

import java.io.Serializable;

public class MovieResponseModel implements Serializable {
    String message;

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }
}
