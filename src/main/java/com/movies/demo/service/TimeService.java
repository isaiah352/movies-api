package com.movies.demo.service;

import com.movies.demo.model.TimeResponseModel;

import javax.xml.ws.WebServiceException;

public interface TimeService {
    TimeResponseModel getTime() throws WebServiceException;
}
