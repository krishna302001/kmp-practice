package com.kmp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateExample {
    public static void main(String[] args) {
        System.out.println(convertDateToISODate(new Date()));
    }
    public static String convertDateToISODate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String date1= sdf.format(date);
        return date1;
    }
}