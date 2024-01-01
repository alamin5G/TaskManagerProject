package com.goonok.util;

import com.goonok.service.TaskService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static Date parseDate(String date){
        try{
            return dateFormat.parse(date);
        }catch (ParseException e){
            throw new RuntimeException("Error on parsing date: " + e.getMessage());
        }
    }


    public static String formatDate(Date date){
        return dateFormat.format(date);
    }

}
