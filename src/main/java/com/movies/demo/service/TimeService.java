package com.movies.demo.service;

import com.movies.demo.model.TimeResponseModel;

import javax.xml.ws.WebServiceException;
import java.util.Date;

public interface TimeService {
    TimeResponseModel getTime() throws WebServiceException;
}
