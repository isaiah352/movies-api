package com.movies.demo.service;

import com.movies.demo.model.TimeResponseModel;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class TimeServiceImpl implements TimeService{
    @Override
    public TimeResponseModel getTime() {
        TimeResponseModel timeResponseModel = new TimeResponseModel();
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        String formattedDate = dateFormat.format(date);
        if(formattedDate.charAt(0) == '0') {
            formattedDate = formattedDate.substring(1);
        }
        timeResponseModel.setTime(formattedDate);
        return timeResponseModel;
    }
}
